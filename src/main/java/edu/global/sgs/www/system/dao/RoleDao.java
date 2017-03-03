package edu.global.sgs.www.system.dao;


import edu.global.sgs.www.entity.Role;

import java.util.List;

public interface RoleDao {

    void createRole(Role role);

    void updateRole(Role role);

    void deleteRole(Long roleId);

    Role findOne(Long roleId);

    Role findByDescription(String description);

    List<Role> findAll();
}
