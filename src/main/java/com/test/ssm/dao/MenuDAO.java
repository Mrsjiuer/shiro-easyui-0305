package com.test.ssm.dao;

import com.test.ssm.pojo.Menu;

import java.util.List;

public interface MenuDAO {

    List<Menu> getAllMenu();

    void deleteMenu(Integer id);

    void updateParentId(Integer id);

    void addMenu(Menu menu);

    Menu getMenuById(Integer id);

    void updateMenu(Menu menu);

    List<Menu> getUserMenu(Integer userId);

    List<Integer> getMenuRoleId(Integer menuId);
}
