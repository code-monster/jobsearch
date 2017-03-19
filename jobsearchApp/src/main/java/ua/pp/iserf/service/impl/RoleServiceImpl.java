package ua.pp.iserf.service.impl;

import ua.pp.iserf.dao.RoleDAO;
import ua.pp.iserf.entity.Role;
import ua.pp.iserf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(final RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public void create(Role role) {
        roleDAO.create(role);
    }

    @Override
    public void update(Role role) {
        roleDAO.update(role);
    }

    @Override
    public void delete(Role role) {
        roleDAO.delete(role);
    }

    @Override
    public Role findById(Long id) {
        return roleDAO.findById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleDAO.findByName(name);
    }

    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

}
