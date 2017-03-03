package edu.global.sgs.www.entity.custom;

import edu.global.sgs.www.entity.User;

public class UserVo extends User {
    private String roleIdsStr;

    @Override
    public String getRoleIdsStr() {
        return roleIdsStr;
    }

    @Override
    public void setRoleIdsStr(String roleIdsStr) {
        this.roleIdsStr = roleIdsStr;
    }
}
