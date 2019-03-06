package com.test.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.ssm.dao.AdminUserDAO;
import com.test.ssm.pojo.AdminUser;
import com.test.ssm.service.AdminUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserDAO adminUserDAO;

//    @Override
//    public AdminUser doLogin(String email, String password) {
//        Subject subject= SecurityUtils.getSubject();
//        UsernamePasswordToken token=new UsernamePasswordToken(email,password);
//        subject.login(token);
//        AdminUser user = adminUserDAO.getUserByEmail(email);
//        if (user == null || !user.getPassword().equals(password)) {
//            return null;
//        }
//        return user;
//        return null;
//    }

    @Override
    public PageInfo<AdminUser> getUserList(AdminUser user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(adminUserDAO.getUserList(user));
    }

    @Override
    public void addUserRole(Integer userId, Integer[] roleIds) {
        adminUserDAO.deleteUserRole(userId);
        for (Integer roleId : roleIds) {
            adminUserDAO.addUserRole(roleId,userId);
        }
    }

    @Override
    public List<Integer> getUserRoleIds(Integer userId) {
        return adminUserDAO.getUserRoleIds(userId);
    }
}
