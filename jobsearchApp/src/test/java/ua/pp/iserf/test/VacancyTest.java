package ua.pp.iserf.test;

import java.sql.SQLException;
import java.util.List;
import org.dbunit.dataset.DataSetException;
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
    }

    @Test
    public void shouldCreateVacancy() {
        //given
        Vacancy vacancy = new Vacancy("Java Junior 1", "Absolut", 
                Helper.convertStringToSqlDate("17/07/2016"), "500", "Kharkov",
                "description text",  "https://bitbucket.org/10000", "Emulate Parser");

        Assert.assertNull(vacancyService.findByOriginalLink("https://bitbucket.org/10000"));
        //when
        vacancyService.create(vacancy);
        //then
        Vacancy vacancyFromDB = vacancyService.findByOriginalLink("https://bitbucket.org/10000");
        Assert.assertNotNull(vacancyFromDB);
        //deleting  new row
        vacancyService.delete(vacancyFromDB);
    }

    @Test
    public void shouldDeleteVacancy() {
        //given
        Vacancy vacancy = vacancyService.findById(503l);
        Assert.assertNotNull(vacancy);
        //when
        vacancyService.delete(vacancy);
        //then
        Assert.assertNull(vacancyService.findById(503l));
    }

    @Test
    public void shouldUpdateVacancy() {
        //given
        Vacancy vacancy = vacancyService.findById(504l);
        String newVacancyName = "Java senior";
        vacancy.setVacancyName(newVacancyName);
        //when
        vacancyService.update(vacancy);
        //then
        Assert.assertTrue(vacancyService.findById(504l).getVacancyName().equals(newVacancyName));
    }

    @Test
    public void shouldFindVacancyByVacancyId() {
        //given
        String expectedOriginalLink = "https://bitbucket.org/1";
        //when
        Vacancy vacancy = vacancyService.findById(501l);
        //then
        Assert.assertTrue(vacancy.getOriginalLink().equals(expectedOriginalLink));
    }

    @Test
    public void shouldFindAllVacancys() throws DataSetException {
        List<Vacancy> vacancys = vacancyService.findAll();
        Assert.assertTrue(vacancys.size() == 4);
    }

    @Test
    public void shouldFindVacancyByOriginalLink() {
        //given
        Long expectedVacancyId = 504l;
        //when
        Vacancy vacancy = vacancyService.findByOriginalLink("https://bitbucket.org/4");
        //then
        Assert.assertTrue(vacancy.getVacancyId().equals(expectedVacancyId));
    }
}
