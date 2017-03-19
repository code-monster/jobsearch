package ua.pp.iserf.parser.modules.blogspot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.pp.iserf.parser.core.Module;
import ua.pp.iserf.service.VacancyService;

@Component
public class BlogspotParser extends Module {

    public final String BASE_URL = "http://javajobsearchapp.blogspot.com/";
    private Thread thread;
    private VacancyService vacancyService;

    @Autowired
    public BlogspotParser(final VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @Override
    public void begin() {
        BlogspotWorker blogspotWorker = new BlogspotWorker(vacancyService, BASE_URL, this.getName());
        thread = new Thread(blogspotWorker);
        thread.start();
    }

    @Override
    public void end() {
        thread.interrupt();
    }

    @Override
    public String getName() {
        return "Blogspot Parser";
    }

}
