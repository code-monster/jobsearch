package ua.pp.iserf.dao;

import ua.pp.iserf.entity.Vacancy;
import java.util.List;
import java.util.Map;

/**
 * Created by alex
 */
public interface VacancyDAO {

    public void create(Vacancy detail);

    public void update(Vacancy detail);

    public void delete(Vacancy detail);

    public Vacancy findById(Long detailId);

    public List<Vacancy> findAll();

    public Vacancy findByOriginalLink(String originalLink);

    public Map<String, Vacancy> findAllVacancyByProviderName(String providerName);

}
