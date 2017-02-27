package ua.pp.iserf.parser.modules.blogspot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.pp.iserf.parser.core.Module;
import ua.pp.iserf.service.VacancyService;

/**
 *
 * @author alex
 */
@Component
public class BlogspotParser extends Module {

    public final String BASE_URL = "http://javajobsearchapp.blogspot.com/";
    private Thread thread;

    @Autowired
    VacancyService vacancyService;

    public BlogspotParser() {
        setEnable(true);
        setName("Blogspot Parser");
    }

    public void start() {
        if (isEnable() == false) {
            return;
        }

        BlogspotWorker blogspotWorker = new BlogspotWorker(vacancyService, BASE_URL, this.getName());
        thread = new Thread(blogspotWorker);
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
