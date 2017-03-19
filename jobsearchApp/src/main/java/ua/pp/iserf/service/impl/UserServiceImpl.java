package ua.pp.iserf.service.impl;

import ua.pp.iserf.dao.UserDAO;
import ua.pp.iserf.entity.User;
import ua.pp.iserf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(final UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void create(User user) {
        userDAO.create(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public User findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return userDAO.findByLogin(login);
    }

}
