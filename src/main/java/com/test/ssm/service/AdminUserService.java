package com.test.ssm.service;

import com.github.pagehelper.PageInfo;
import com.test.ssm.pojo.AdminUser;

import java.util.List;

public interface AdminUserService {
    //AdminUser doLogin(String email, String password);

    PageInfo<AdminUser> getUserList(AdminUser user, Integer pageNum, Integer pageSize);

    void addUserRole(Integer userId, Integer[] roleIds);

    List<Integer> getUserRoleIds(Integer userId);

    void deleteUserAdmin(Integer[] ids);

    void deleteUserRole(Integer roleId);

    AdminUser getUserById(Integer id);
}
