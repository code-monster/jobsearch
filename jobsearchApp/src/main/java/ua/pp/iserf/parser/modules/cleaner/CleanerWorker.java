package ua.pp.iserf.parser.modules.cleaner;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;
import ua.pp.iserf.entity.Vacancy;
import ua.pp.iserf.service.VacancyService;

/**
 *
 * @author alex
 */
public class CleanerWorker implements Runnable {

    private VacancyService vacancyService;
    private final long SLEEP_TIME =  TimeUnit.SECONDS.toMillis(5);

    public CleanerWorker(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @Override
    public void run() {
        int counter = 0;
        while (Thread.currentThread().isInterrupted() == false) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp + " CleanerWorker counter=" + counter);
            counter++;

            List<Vacancy> allDbVacancies = vacancyService.findAll();
            for (Vacancy vacancy : allDbVacancies) {
                if (vacancyService.isVacancyOlderThanTwoWeeks(vacancy)) {
                    System.out.println("Vacancy will be deleted: " + vacancy.toString());
                    vacancyService.delete(vacancy);
                }
            }

            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("CleanerWorker is interrupted!");
            }
        }

    }

}
