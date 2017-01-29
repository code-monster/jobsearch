package ua.pp.iserf.parser.modules.blogspot;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ua.pp.iserf.entity.Vacancy;

/**
 *
 * @author alex
 */
public class SingleVacancyParser {

    private String baseUrl;

    public void SingleVacancyParser() {

    }

    public void SingleVacancyParser(String baseUrl) {
        this.setBaseUrl(baseUrl);
    }

    public Vacancy getVacancy() {
        Vacancy vacancy = new Vacancy();
        Document doc = getDocument(getBaseUrl());
        vacancy.setVacancyName(doc.select(".entry-content h1").text());
        vacancy.setDescription(cutDescription(doc.select(".entry-content p.description").text()));
        vacancy.setCreationDate(getTempDate());
        vacancy.setOriginalLink("https://github.com/code-monster/jobsearch");

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

    public java.sql.Date getTempDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = new java.util.Date();
        try {
            utilDate = sdf.parse("21/12/2012");
        } catch (ParseException ex) {
            Logger.getLogger(BlogspotParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        return sqlDate;
    }

    public String cutDescription(String description) {
        if(description.length()>255){
         description = description.substring(0,250) + "...";
        }
        return description;
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
