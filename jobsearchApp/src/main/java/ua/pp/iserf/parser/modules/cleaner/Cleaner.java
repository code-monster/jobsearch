package ua.pp.iserf.parser.modules.cleaner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.pp.iserf.parser.core.Module;
import ua.pp.iserf.service.VacancyService;

/**
 *
 * @author alex
 */
@Component
public class Cleaner extends Module {

    private Thread thread;

    @Autowired
    VacancyService vacancyService;

    public Cleaner() {
        setEnable(true);
        setName("Cleaner");
    }

    public void start() {
        if (isEnable() == false) {
            return;
        }
        CleanerWorker cleanerWorker = new CleanerWorker(vacancyService);
        thread = new Thread(cleanerWorker);
        thread.start();
        running = true;
    }

    public void stop() {
        if (isEnable() == false) {
            return;
        }
        thread.interrupt();
        running = false;
    }

}
