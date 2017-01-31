package ua.pp.iserf.parser.modules.blogspot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.pp.iserf.entity.Vacancy;
import ua.pp.iserf.parser.core.Provider;
import ua.pp.iserf.service.VacancyService;

/**
 *
 * @author alex
 */
@Component
public class BlogspotParser extends Provider {

    public final String BASE_URL = "http://javajobsearchapp.blogspot.com/";

    @Autowired
    VacancyService vacancyService;

    public BlogspotParser() {
        setRunningStatus(false);
        setEnable(true);
        setName("Blogspot Parser");
    }

    public void start() {
        if (isEnable() == false) {
            return;
        }
        this.setEnable(true);
        List allPageUrl = getAllUrl();
        // for test
        System.out.println(java.util.Arrays.deepToString(allPageUrl.toArray()));

        Map<String, Vacancy> allProviderVacancyInDB = vacancyService.findAllVacancyByProviderName(this.getName());
        List<Vacancy> freshVacancyList = new ArrayList<Vacancy>();
        SingleVacancyParser singleVacancyParser = new SingleVacancyParser(this.getName());

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

    }

    public void stop() {
        if (isEnable() == false) {
            return;
        }
        setRunningStatus(false);
    }

    protected Document getDocument(String urlOpen) {
        Document doc;
        try {
            doc = Jsoup.connect(urlOpen).get();
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
        return doc;
    }

    protected ArrayList getAllUrl() {
        ArrayList allPageUrl = new ArrayList();
        Document doc = null;
        doc = getDocument(BASE_URL);
        Elements allLinks = doc.select("a.timestamp-link");

        for (Element link : allLinks) {
            allPageUrl.add(link.attr("abs:href"));
        }

        return allPageUrl;
    }

}
