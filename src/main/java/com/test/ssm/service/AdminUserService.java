package com.test.ssm.service;

import com.github.pagehelper.PageInfo;
import com.test.ssm.pojo.AdminUser;

import java.util.List;

public interface AdminUserService {
    //AdminUser doLogin(String email, String password);

    PageInfo<AdminUser> getUserList(AdminUser user, Integer pageNum, Integer pageSize);

    void addUserRole(Integer userId, Integer[] roleIds);

    List<Integer> getUserRoleIds(Integer userId);

    void updateUserAdmin(AdminUser adminUser);

    void deleteUserAdmin(Integer[] ids);

    void deleteUserRole(Integer roleId);
void addAdmin(AdminUser adminUser);
    AdminUser getUserById(Integer id);
}
