package ua.pp.iserf.dao;

import java.util.List;
import ua.pp.iserf.entity.Role;

public interface RoleDAO {

    public void create(Role role);

    public void update(Role role);

    public void delete(Role role);

    public Role findById(Long roleId);

    public Role findByName(String roleName);

    public List<Role> findAll();
}
