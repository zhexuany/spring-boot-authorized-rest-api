package edu.global.sgs.www.system.service.impl;

import edu.global.sgs.www.college.dao.StaffDao;
import edu.global.sgs.www.entity.Role;
import edu.global.sgs.www.entity.Staff;
import edu.global.sgs.www.entity.User;
import edu.global.sgs.www.entity.custom.UserVo;
import edu.global.sgs.www.system.dao.RoleDao;
import edu.global.sgs.www.system.dao.UserDao;
import edu.global.sgs.www.system.service.RoleBiz;
import edu.global.sgs.www.system.service.UserBiz;
import edu.global.sgs.www.util.PasswordHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Service
public class UserBizImpl implements UserBiz {

    @Resource
    private UserDao userDao;

    @Resource
    private RoleDao roleDao;

    @Resource
    private StaffDao staffDao;

    @Resource
    private PasswordHelper passwordHelper;
    @Resource(name = "roleBizImpl")
    private RoleBiz roleBiz;

    @Override
    public List<UserVo> findAll() throws InvocationTargetException, IllegalAccessException {
        List<UserVo> userVoList = new ArrayList<>();
        List userList = userDao.findAll();


        for (Object anUserList : userList) {
            StringBuilder s = new StringBuilder();
            User user = (User) anUserList;
            List<Long> roleIds = user.getRoleIds();

            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(userVo, user);

            if (roleIds != null) {
                int i = 0;
                int size = roleIds.size();
                for (; i < size - 1; i++) {
                    Role role = roleDao.findOne(roleIds.get(i));

                    s.append(role.getDescription());
                    s.append(",");
                }
                Role role = roleDao.findOne(roleIds.get(i));
                s.append(role.getDescription());
                userVo.setRoleIdsStr(s.toString());
            }


            userVoList.add(userVo);

        }

        return userVoList;
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    public void add(User user) {
        //TODO 这里为了完成功能直接按照权限判断添加到staff中,应该新增一个前端页面,进行教师的管理- -!!时间没了,这么做太2了

        passwordHelper.encryptPassword(user);
        userDao.add(user);
        String id = user.getUserId();
        String teacherRoleId = roleDao.findByDescription("老师").getId().toString();
        if (user.getRoleIdsStr().indexOf(teacherRoleId) != -1) {
            Staff staff = new Staff();
            staff.setStaffId(id);
            staff.setStaffName(id);
            staffDao.add(staff);
        }


    }

    //TODO 删除staff和student连带的功能未完成
    @Transactional
    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public void changePassword(String userId, String newPassword) {
        User user = userDao.findById(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.update(user);

    }

    @Override
    public User findByUsername(String username) {
        return userDao.findById(username);
    }

    @Override
    public Set findRoles(String username) {
        User user = findByUsername(username);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        return roleBiz.findRoles(user.getRoleIds().toArray(new Long[0]));
    }

    @Override
    public Set findPermissions(String username) {
        User user = findByUsername(username);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        return roleBiz.findPermissions(user.getRoleIds().toArray(new Long[0]));
    }
}

