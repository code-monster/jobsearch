package ua.pp.iserf.parser.modules.cleaner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.pp.iserf.parser.core.Module;
import ua.pp.iserf.service.VacancyService;

@Component
public class Cleaner extends Module {

    private Thread thread;
    private VacancyService vacancyService;

    @Autowired
    public Cleaner(final VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @Override
    public void begin() {
        CleanerWorker cleanerWorker = new CleanerWorker(vacancyService);
        thread = new Thread(cleanerWorker);
        thread.start();
    }

    @Override
    public void end() {
        thread.interrupt();
    }

    @Override
    public String getName() {
        return "Cleaner";
    }

}
