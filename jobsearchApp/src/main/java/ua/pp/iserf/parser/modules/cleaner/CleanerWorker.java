package ua.pp.iserf.parser.modules.cleaner;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.pp.iserf.entity.Vacancy;
import ua.pp.iserf.service.VacancyService;

public class CleanerWorker implements Runnable {

    private final static Logger LOG = LogManager.getLogger();
    private VacancyService vacancyService;
    private final long SLEEP_TIME = TimeUnit.SECONDS.toMillis(20);

    public CleanerWorker(final VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @Override
    public void run() {
        int counter = 0;
        while (Thread.currentThread().isInterrupted() == false) {
            LOG.info("CleanerWorker counter=" + counter);
            counter++;

            List<Vacancy> allDbVacancies = vacancyService.findAll();
            for (Vacancy vacancy : allDbVacancies) {
                if (vacancyService.isVacancyOlderThanTwoWeeks(vacancy)) {
                    LOG.info("Vacancy will be deleted: " + vacancy.toString());
                    vacancyService.delete(vacancy);
                }
            }

            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                LOG.info("CleanerWorker is interrupted!");
            }
        }

    }

}
