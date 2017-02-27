package ua.pp.iserf.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.pp.iserf.config.DBUnitConfig;
import ua.pp.iserf.entity.Vacancy;
import ua.pp.iserf.service.VacancyService;
import ua.pp.iserf.util.Helper;

@WebAppConfiguration
public class VacancyTest extends DBUnitConfig {

    @Autowired
    private VacancyService vacancyService;

    private Vacancy vacancyTemp1;
    private Vacancy vacancyTemp2;

    public VacancyTest() throws SQLException, ClassNotFoundException {
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        FlatXmlDataSetBuilder flatXmlProducer = new FlatXmlDataSetBuilder();
        flatXmlProducer.setColumnSensing(false);
        beforeData = new FlatXmlDataSetBuilder().build(VacancyTest.class.getResourceAsStream("/Vacancy/Vacancy.xml"));
        tester.setDataSet(beforeData);
        tester.onSetup();

        vacancyTemp1 = new Vacancy("Java Junior 1", "Absolut",
                Helper.convertStringToSqlDate("17/07/2016"), "500", "Kharkov",
                "description text", "https://bitbucket.org/10000", "Emulate Parser");
        vacancyTemp2 = new Vacancy("Java Junior 1", "Absolut",
                Helper.convertStringToSqlDate("17/07/2016"), "500", "Kharkov",
                "description text", "https://bitbucket.org/10001", "Emulate Parser");
    }

    @Test
    public void shouldCreateVacancy() {
        //given
        Assert.assertNull(vacancyService.findByOriginalLink("https://bitbucket.org/10000"));
        //when
        vacancyService.create(vacancyTemp1);
        //then
        Vacancy vacancyFromDB = vacancyService.findByOriginalLink("https://bitbucket.org/10000");
        Assert.assertNotNull(vacancyFromDB);
        //deleting  new row
        vacancyService.delete(vacancyFromDB);
    }

    @Test
    public void shouldCreateVacancyWithCyrillic() {

        //given
        final String VACANCY_NAME = "Вакансия младшего специалиста";
        final String VACANCY_CITY = "Харьков";
        final String VACANCY_DESCRIPTION = "описание вакансии текст";
        Vacancy vacancyCyrillic = new Vacancy(VACANCY_NAME, "Absolut",
                Helper.convertStringToSqlDate("17/07/2016"), "500", VACANCY_CITY,
                VACANCY_DESCRIPTION, "https://bitbucket.org/10010", "Emulate Parser");

        Assert.assertNull(vacancyService.findByOriginalLink("https://bitbucket.org/10010"));
        //when
        vacancyService.create(vacancyCyrillic);
        //then
        Vacancy vacancyFromDB = vacancyService.findByOriginalLink("https://bitbucket.org/10010");
        Assert.assertNotNull(vacancyFromDB);
        Assert.assertEquals(VACANCY_NAME, vacancyFromDB.getVacancyName());
        Assert.assertEquals(VACANCY_CITY, vacancyFromDB.getLocation());
        Assert.assertEquals(VACANCY_DESCRIPTION, vacancyFromDB.getDescription());
        //deleting  new row
        vacancyService.delete(vacancyFromDB);
    }

    @Test
    public void shouldCreateListofVacancy() {
        //given
        List<Vacancy> vacancyList = new ArrayList<>();
        vacancyList.add(vacancyTemp1);
        vacancyList.add(vacancyTemp2);

        Assert.assertNull(vacancyService.findByOriginalLink("https://bitbucket.org/10000"));
        Assert.assertNull(vacancyService.findByOriginalLink("https://bitbucket.org/10001"));
        //when
        vacancyService.createListofVacancy(vacancyList);
        //then
        Vacancy vacancyFromDB1 = vacancyService.findByOriginalLink("https://bitbucket.org/10000");
        Assert.assertNotNull(vacancyFromDB1);

        Vacancy vacancyFromDB2 = vacancyService.findByOriginalLink("https://bitbucket.org/10001");
        Assert.assertNotNull(vacancyFromDB2);
    }

    @Test
    public void shouldDeleteVacancy() {
        //given
        Vacancy vacancy = vacancyService.findById(503L);
        Assert.assertNotNull(vacancy);
        //when
        vacancyService.delete(vacancy);
        //then
        Assert.assertNull(vacancyService.findById(503L));
    }

    @Test
    public void shouldUpdateVacancy() {
        //given
        Vacancy vacancy = vacancyService.findById(504L);
        String newVacancyName = "Java senior";
        vacancy.setVacancyName(newVacancyName);
        //when
        vacancyService.update(vacancy);
        //then
        Assert.assertTrue(vacancyService.findById(504L).getVacancyName().equals(newVacancyName));
    }

    @Test
    public void shouldFindVacancyByVacancyId() {
        //given
        String expectedOriginalLink = "https://bitbucket.org/1";
        //when
        Vacancy vacancy = vacancyService.findById(501L);
        //then
        Assert.assertTrue(vacancy.getOriginalLink().equals(expectedOriginalLink));
    }

    @Test
    public void shouldFindAllVacancys() {
        List<Vacancy> vacancys = vacancyService.findAll();
        Assert.assertTrue(vacancys.size() == 4);
    }

    @Test
    public void shouldFindAllVacancysAndSortByDate() {
        List<Vacancy> vacancys = vacancyService.findAll();
        Assert.assertEquals(new Long(501L), vacancys.get(0).getVacancyId());
        Assert.assertEquals(new Long(502L), vacancys.get(1).getVacancyId());
        Assert.assertEquals(new Long(504L), vacancys.get(2).getVacancyId());
        Assert.assertEquals(new Long(503L), vacancys.get(3).getVacancyId());
    }

    @Test
    public void shouldCheckIsVacancyOlderThanTwoWeeks() {

        //given
        LocalDate today = LocalDate.now();
        LocalDate dayMonthAgo = today.minusMonths(1);
        vacancyTemp1.setCreationDate(java.sql.Date.valueOf(today));
        vacancyTemp2.setCreationDate(java.sql.Date.valueOf(dayMonthAgo));

        //when
        boolean resultForToday = vacancyService.isVacancyOlderThanTwoWeeks(vacancyTemp1);
        boolean resultForDayMonthAgo = vacancyService.isVacancyOlderThanTwoWeeks(vacancyTemp2);

        //then
        Assert.assertFalse(resultForToday);
        Assert.assertTrue(resultForDayMonthAgo);
    }

    @Test
    public void shouldFindVacancyByOriginalLink() {
        //given
        Long expectedVacancyId = 504L;
        //when
        Vacancy vacancy = vacancyService.findByOriginalLink("https://bitbucket.org/4");
        //then
        Assert.assertTrue(vacancy.getVacancyId().equals(expectedVacancyId));
    }

    @Test
    public void shouldFindAllVacancyByProviderName() {

        Map<String, Vacancy> vacancyMap = vacancyService.findAllVacancyByProviderName("Blogspot Parser");
        Assert.assertTrue(vacancyMap.size() == 3);
    }
}
