package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.test.ssm.util.AjaxMessage;
import com.test.ssm.pojo.Menu;
import com.test.ssm.pojo.Role;
import com.test.ssm.util.TableData;
import com.test.ssm.service.MenuService;
import com.test.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("role.html")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @RequestMapping
    public String page() {
        return "role";
    }

    @RequestMapping(params = "act=table")
    @ResponseBody
    public TableData table(Role role, Integer page, Integer rows) {
        PageInfo<Role> pageInfo = roleService.getRoleList(role, page, rows);
        return new TableData(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping(params = "act=menu_tree")
    @ResponseBody
    public List<Menu> menuTree() {
        return menuService.getMenuTree();
    }
    @RequestMapping(params = "act=go_menu")
    public String menuPage() {
        return "role_menu";
    }
    @RequestMapping(params = "act=assign_menu")
    @ResponseBody
    public AjaxMessage assign(Integer roleId, Integer[] menuIds) {
        try {
            roleService.addRoleMenu(roleId, menuIds);
            return new AjaxMessage(true, "分配成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false, "分配失败");
        }
    }
    @RequestMapping(params = "act=role_menu")
    @ResponseBody
    public List<Integer> roleMenu(Integer roleId) {
        return roleService.getRoleMenuIds(roleId);
    }

}
