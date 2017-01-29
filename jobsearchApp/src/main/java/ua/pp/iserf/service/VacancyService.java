package ua.pp.iserf.service;

import ua.pp.iserf.entity.Vacancy;
import java.util.List;

public interface VacancyService {

    public void create(Vacancy vacancy);

    public void update(Vacancy vacancy);

    public void delete(Vacancy vacancy);

    public Vacancy findById(Long vacancyId);

    public List<Vacancy> findAll();

    public Vacancy findByOriginalLink(String originalLink);

}
