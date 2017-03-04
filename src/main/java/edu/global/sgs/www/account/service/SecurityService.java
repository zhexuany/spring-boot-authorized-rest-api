package edu.global.sgs.www.account.service;

public interface SecurityService {
    String findLoggedInUsername();
    public void autoLogin(String username, String password);
}

