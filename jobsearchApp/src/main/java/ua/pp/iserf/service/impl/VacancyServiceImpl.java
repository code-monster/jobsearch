package ua.pp.iserf.service.impl;

import ua.pp.iserf.dao.VacancyDAO;
import ua.pp.iserf.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import ua.pp.iserf.entity.Vacancy;

@Service
@Transactional
public class VacancyServiceImpl implements VacancyService {

    private VacancyDAO vacancyDAO;

    @Autowired
    public void setDetailDAO(VacancyDAO vacancyDAO) {
        this.vacancyDAO = vacancyDAO;
    }

    @Override
    public void create(Vacancy vacancy) {
        vacancyDAO.create(vacancy);
    }

    @Override
    public void update(Vacancy vacancy) {
        vacancyDAO.update(vacancy);
    }

    @Override
    public void delete(Vacancy vacancy) {
        vacancyDAO.delete(vacancy);
    }

    @Override
    public Vacancy findById(Long id) {
        return vacancyDAO.findById(id);
    }

    @Override
    public List<Vacancy> findAll() {
        return vacancyDAO.findAll();
    }

    @Override
    public Vacancy findByOriginalLink(String originalLink) {
        return vacancyDAO.findByOriginalLink(originalLink);
    }

    @Override
    public Map<String, Vacancy> findAllVacancyByProviderName(String providerName) {
        return vacancyDAO.findAllVacancyByProviderName(providerName);
    }

    @Override
    public void createListofVacancy(List<Vacancy> vacancyList) {
        for (Vacancy vacancy : vacancyList) {
            vacancyDAO.create(vacancy);
        }
    }

}
