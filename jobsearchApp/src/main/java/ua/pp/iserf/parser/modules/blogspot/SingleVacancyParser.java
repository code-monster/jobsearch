package ua.pp.iserf.parser.modules.blogspot;

import java.io.IOException;
import java.time.LocalDate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ua.pp.iserf.entity.Vacancy;

public class SingleVacancyParser {

    private String baseUrl;
    private String providerName;
    private final int DESCRIPTION_SIZE = 255;

    public SingleVacancyParser(String providerName) {
        this.providerName = providerName;
    }

    public Vacancy getVacancy() {
        Vacancy vacancy = new Vacancy();
        Document doc = getDocument(getBaseUrl());
        vacancy.setVacancyName(doc.select(".entry-content h1").text());
        vacancy.setDescription(cutDescription(doc.select(".entry-content p.description").text()));
        vacancy.setCreationDate(getTodayDate());
        vacancy.setOriginalLink(baseUrl);
        vacancy.setProvider(providerName);

        return vacancy;
    }

    private Document getDocument(String urlOpen) {
        Document doc;
        try {
            doc = Jsoup.connect(urlOpen).get();
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
        return doc;
    }

    private java.sql.Date getTodayDate() {
        LocalDate today = LocalDate.now();
        return java.sql.Date.valueOf(today);
    }

    private String cutDescription(String description) {
        if (description.length() > DESCRIPTION_SIZE) {
            description = description.substring(0, DESCRIPTION_SIZE - 5) + "...";
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
