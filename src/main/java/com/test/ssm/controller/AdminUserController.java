package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.test.ssm.pojo.AdminUser;
import com.test.ssm.pojo.PayChannel;
import com.test.ssm.pojo.Role;
import com.test.ssm.service.AdminUserService;
import com.test.ssm.service.RoleService;
import com.test.ssm.util.AjaxMessage;
import com.test.ssm.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/adminuser.html")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private RoleService roleService;

    @RequestMapping
    public String page() {
        return "admin_user";
    }

    @RequestMapping(params = "act=table")
    @ResponseBody
    public TableData table(AdminUser adminUser, Integer page, Integer rows) {
        PageInfo<AdminUser> pageInfo = adminUserService.getUserList(adminUser, page, rows);
        return new TableData(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping(params = "act=go_role")
    public String rolePage(){
        return "user_role";
    }
    @RequestMapping(params = "act=role_tree")
    @ResponseBody
    public List<Role> roleList() {
        return roleService.getRoleList(null);
    }

    @RequestMapping(params = "act=user_role")
    @ResponseBody
    public List<Integer> userRole(Integer userId){
        return adminUserService.getUserRoleIds(userId);
    }

    @RequestMapping(params = "act=assign_role")
    @ResponseBody
    public AjaxMessage assignRole(Integer userId,Integer[] roleIds){
        try {
            adminUserService.addUserRole(userId,roleIds);
            return new AjaxMessage(true,"分配成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
         return new AjaxMessage(false,"分配失败");
    }

    @RequestMapping(params = "act=go_admin")
    public String goUpdate(Integer id, HttpServletRequest request) {
        System.out.println(id);
        if(id!=null){
            AdminUser adminUser = adminUserService.getUserById(id);
            request.setAttribute("adminUser", adminUser);
        }
        return "updateAdmin";
    }
    @RequestMapping(params = "act=update_admin")
    @ResponseBody
    public AjaxMessage update(AdminUser adminUser){
        try {
            if(adminUser.getId()==null){
                adminUserService.addAdmin(adminUser);
            }
                adminUserService.updateUserAdmin(adminUser);
            return new AjaxMessage(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false, "修改失败");
        }
    }
//    @RequestMapping(params = "act=add_admin")
//    @ResponseBody
//    public AjaxMessage addUser(AdminUser adminUser){
//        try {
//            adminUserService.addAdmin(adminUser);
//            return new AjaxMessage(true,"添加成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new AjaxMessage(false, "添加失败");
//        }
//    }

    @RequestMapping(params = "act=delete_admin")
    @ResponseBody
    public AjaxMessage delete(Integer[] ids) {
        try {
            adminUserService.deleteUserAdmin(ids);
            return new AjaxMessage(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false, "删除失败");
        }
    }
}
