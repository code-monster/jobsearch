package ua.pp.iserf.parser.modules.blogspot;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author alex
 */
public class ListVacancyParser {

    private String baseUrl;

    public ListVacancyParser(String baseUrl) {
        this.baseUrl = baseUrl;
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

    public ArrayList getAllUrl() {
        ArrayList allPageUrl = new ArrayList();
        Document doc = null;
        doc = getDocument(baseUrl);
        Elements allLinks = doc.select("a.timestamp-link");

        for (Element link : allLinks) {
            allPageUrl.add(link.attr("abs:href"));
        }

        return allPageUrl;
    }

    /**
     * @return the baseUrl
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * @param baseUrl the baseUrl to set
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

}
