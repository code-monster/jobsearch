package ua.pp.iserf.parser.modules.blogspot;

import java.io.IOException;
import org.jsoup.Jsoup;
import ua.pp.iserf.parser.core.beans.Vacancy;
import org.jsoup.nodes.Document;

/**
 *
 * @author alex
 */
public class SingleVacancyParser  {

    private String baseUrl;
    
    public void SingleVacancyParser() {

    }
    
    public void SingleVacancyParser(String baseUrl) {
        this.setBaseUrl(baseUrl);
    }

    public Vacancy getVacancy() {
        Vacancy vacancy = new Vacancy();
        Document doc = getDocument(getBaseUrl());
        vacancy.setTitle(doc.select(".entry-content h1").text());
        vacancy.setDescription(doc.select(".entry-content p.description").text());

        return vacancy;
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
