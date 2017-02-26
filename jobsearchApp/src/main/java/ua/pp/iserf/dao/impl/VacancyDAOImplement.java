package ua.pp.iserf.dao.impl;

import ua.pp.iserf.dao.VacancyDAO;
import ua.pp.iserf.entity.Vacancy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author alex
 */
@Repository
public class VacancyDAOImplement implements VacancyDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Vacancy vacancy) {
        sessionFactory.getCurrentSession().save(vacancy);
    }

    @Override
    public void update(Vacancy vacancy) {
        sessionFactory.getCurrentSession().update(vacancy);
    }

    @Override
    public void delete(Vacancy vacancy) {
        sessionFactory.getCurrentSession().delete(vacancy);
    }

    @Override
    public Vacancy findById(Long vacancyId) {
        return (Vacancy) sessionFactory.getCurrentSession().get(Vacancy.class, vacancyId);
    }

    @Override
    @Transactional
    public List<Vacancy> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Vacancy order by creationDate desc ");
        return new ArrayList<>(query.list());
    }

    @Override
    public List<Vacancy> findByPage(int limit, int offset) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Vacancy order by creationDate desc ")
                .setFirstResult(offset).setMaxResults(limit);
        return new ArrayList<>(query.list());
    }

    @Override
    public Vacancy findByOriginalLink(String originalLink) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Vacancy v where v.originalLink = :originalLink")
                .setString("originalLink", originalLink);
        Vacancy vacancy = null;
        if (!query.list().isEmpty()) {
            vacancy = (Vacancy) query.list().get(0);
        }

        return vacancy;
    }

    @Override
    public Map<String, Vacancy> findAllVacancyByProviderName(String providerName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Vacancy v where v.provider = :provider")
                .setString("provider", providerName);
        List<Vacancy> listVacancy = new ArrayList<>(query.list());
        Map<String, Vacancy> mapVacancy = new HashMap<String, Vacancy>();
        for (Vacancy vacancy : listVacancy) {
            mapVacancy.put(vacancy.getOriginalLink(), vacancy);
        }

        return mapVacancy;
    }

}
