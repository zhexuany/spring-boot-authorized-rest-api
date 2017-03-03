package edu.global.sgs.www.system.service.impl;

import edu.global.sgs.www.entity.User;
import edu.global.sgs.www.system.dao.UserDao;
import edu.global.sgs.www.system.service.AccountBiz;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountBizImpl implements AccountBiz {

    @Resource
    private UserDao userDao;

    @Override
    public User findByIdAndPassword(String username, String password) {
        return userDao.findByIdAndPassword(username, password);
    }


    @Override
    public void updatePassword(String id, String password) {
        userDao.updatePassword(id, password);
    }
}
