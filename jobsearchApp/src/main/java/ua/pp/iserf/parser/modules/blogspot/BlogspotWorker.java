package ua.pp.iserf.parser.modules.blogspot;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import ua.pp.iserf.entity.Vacancy;
import ua.pp.iserf.service.VacancyService;

/**
 *
 * @author alex
 */
public class BlogspotWorker implements Runnable {

    private VacancyService vacancyService;
    private final long SLEEP_TIME = TimeUnit.SECONDS.toMillis(5);
    private String providerName;
    public final String BASE_URL;

    public BlogspotWorker(VacancyService vacancyService, String baseUrl, String providerName) {
        this.vacancyService = vacancyService;
        BASE_URL = baseUrl;
        this.providerName = providerName;
    }

    @Override
    public void run() {
        int counter = 0;
        while (Thread.currentThread().isInterrupted() == false) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp + " BlogspotWorker counter=" + counter);
            counter++;

            ListVacancyParser listVacancyParser = new ListVacancyParser(BASE_URL);
            List allPageUrl = listVacancyParser.getAllUrl();
            // for test
            System.out.println(java.util.Arrays.deepToString(allPageUrl.toArray()));

            Map<String, Vacancy> allProviderVacancyInDB = vacancyService.findAllVacancyByProviderName(providerName);
            List<Vacancy> freshVacancyList = new ArrayList<Vacancy>();
            SingleVacancyParser singleVacancyParser = new SingleVacancyParser(providerName);

            // to do: need refactor  
            for (Iterator it = allPageUrl.iterator(); it.hasNext();) {
                String url = (String) it.next();
                if (allProviderVacancyInDB.containsKey(url) == false) {
                    singleVacancyParser.setBaseUrl(url);
                    Vacancy vacancy = singleVacancyParser.getVacancy();
                    freshVacancyList.add(vacancy);
                    System.out.println(vacancy.toString());
                }
            }

            System.out.println("we got freshVacancyList = " + freshVacancyList.size());
            vacancyService.createListofVacancy(freshVacancyList);

            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("BlogspotWorker is interrupted!");
            }
        }

    }


}
