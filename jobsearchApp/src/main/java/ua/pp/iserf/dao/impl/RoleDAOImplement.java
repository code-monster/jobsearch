package ua.pp.iserf.dao.impl;

import ua.pp.iserf.dao.RoleDAO;
import ua.pp.iserf.entity.Role;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleDAOImplement implements RoleDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public void update(Role role) {
        sessionFactory.getCurrentSession().update(role);
    }

    @Override
    public void delete(Role role) {
        sessionFactory.getCurrentSession().delete(role);
    }

    @Override
    public Role findById(Long roleId) {
        return (Role) sessionFactory.getCurrentSession().get(Role.class, roleId);
    }

    @Override
    @Transactional
    public Role findByName(String roleName) {

        Query query = sessionFactory.getCurrentSession().createQuery("from Role d where d.roleName = :name").setString("name", roleName);
        Role role = null;
        if (!query.list().isEmpty()) {
            role = (Role) query.list().get(0);
        }

        return role;
    }

    @Override
    @Transactional
    public List<Role> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Role");
        return new ArrayList<>(query.list());
    }

}
