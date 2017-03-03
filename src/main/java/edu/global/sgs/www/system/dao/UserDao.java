package edu.global.sgs.www.system.dao;

import edu.global.sgs.www.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(String id);

    void update(User user);

    void add(User user);

    void delete(String id);

    User findByIdAndPassword(@Param("id") String username, @Param("password") String password);

    void updatePassword(@Param("userId") String id, @Param("password") String password);

    User findByUsername(String username);
}
