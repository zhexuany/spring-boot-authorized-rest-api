package edu.global.sgs.www.system.service;

import edu.global.sgs.www.entity.User;

public interface AccountBiz {

    User findByIdAndPassword(String username, String password);

    void updatePassword(String id, String password);
}
