package com.test.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.ssm.dao.RoleDAO;
import com.test.ssm.pojo.Role;
import com.test.ssm.service.RoleService;
import com.test.ssm.shiro.MyShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    @Override
    public PageInfo<Role> getRoleList(Role role, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(roleDAO.getRoleList(role));
    }
    @Autowired
    private MyShiroFilterFactoryBean shiroFilterFactoryBean;
    @Override
    public void addRoleMenu(Integer roleId, Integer[] menuIds) {
        roleDAO.deleteRoleMenu(roleId);
        for (Integer menuId : menuIds) {
            roleDAO.addRoleMenu(roleId,menuId);
        }
        shiroFilterFactoryBean.update();
    }

    @Override
    public List<Integer> getRoleMenuIds(Integer roleId) {
        return roleDAO.getRoleMenuIds(roleId);
    }

    @Override
    public List<Role> getRoleList(Role role) {
        return roleDAO.getRoleList(role);
    }
}
