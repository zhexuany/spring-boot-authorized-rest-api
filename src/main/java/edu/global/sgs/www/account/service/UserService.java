package edu.global.sgs.www.account.service;

import edu.global.sgs.www.account.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
