package ua.pp.iserf.dao.impl;

import ua.pp.iserf.dao.UserDAO;
import ua.pp.iserf.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User findById(Long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @Transactional
    public User findByLogin(String login) {

        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.login = :login").setString("login", login);
        User user = null;
        if (!query.list().isEmpty()) {
            user = (User) query.list().get(0);
        }

        return user;
    }

    @Override
    @Transactional
    public List<User> findAll() {

        Query query = sessionFactory.getCurrentSession().createQuery("from User");
        return new ArrayList<>(query.list());

    }

}
