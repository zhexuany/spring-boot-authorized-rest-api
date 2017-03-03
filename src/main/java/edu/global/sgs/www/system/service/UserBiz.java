package edu.global.sgs.www.system.service;


import edu.global.sgs.www.entity.User;
import edu.global.sgs.www.entity.custom.UserVo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

public interface UserBiz {
    List<UserVo> findAll() throws InvocationTargetException, IllegalAccessException;

    User findById(String id);

    void update(User user);

    void add(User user);

    void delete(String id);

    void changePassword(String userId, String newPassword);


    User findByUsername(String username);

    Set findRoles(String username);

    Set findPermissions(String username);
}
