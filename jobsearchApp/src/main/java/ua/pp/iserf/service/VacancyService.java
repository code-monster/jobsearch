package ua.pp.iserf.service;

import ua.pp.iserf.entity.Vacancy;
import java.util.List;
import java.util.Map;

public interface VacancyService {

    public void create(Vacancy vacancy);

    public void update(Vacancy vacancy);

    public void delete(Vacancy vacancy);

    public Vacancy findById(Long vacancyId);

    public List<Vacancy> findAll();

    public Vacancy findByOriginalLink(String originalLink);

    public Map<String, Vacancy> findAllVacancyByProviderName(String providerName);

    public void createListofVacancy(List<Vacancy> vacancyList);

    public boolean isVacancyOlderThanTwoWeeks(Vacancy vacancy);

}
