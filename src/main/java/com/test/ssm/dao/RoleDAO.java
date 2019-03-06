package com.test.ssm.dao;

import com.test.ssm.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDAO {
    List<Role> getRoleList(Role role);

    void addRoleMenu(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);

    void deleteRoleMenu(Integer roleId);

    List<Integer> getRoleMenuIds(Integer roleId);
}
