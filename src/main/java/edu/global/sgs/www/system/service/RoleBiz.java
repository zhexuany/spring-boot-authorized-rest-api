package edu.global.sgs.www.system.service;


import edu.global.sgs.www.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleBiz {


    void createRole(Role role);

    void updateRole(Role role);

    void deleteRole(Long roleId);

    Role findOne(Long roleId);

    List<Role> findAll();

    /**
     * 根据角色编号得到角色标识符列表
     *
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 根据角色编号得到权限字符串列表
     *
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);
}
