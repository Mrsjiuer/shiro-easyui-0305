package com.test.ssm.dao;

import com.test.ssm.pojo.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserDAO {
    List<AdminUser> getUserList(AdminUser user);

    AdminUser getUserByEmail(String email);

    void addUserRole(@Param("roleId") Integer roleId, @Param("userId") Integer userId);

    void deleteUserRole(Integer roleId);

    void updateUserAdmin(AdminUser adminUser);
    void addAdmin(AdminUser adminUser);

    List<Integer> getUserRoleIds(Integer userId);

    void deleteUserAdmin(Integer id);

    AdminUser getUserById(Integer id);
}
