package com.test.ssm.controller;

import com.test.ssm.pojo.AdminUser;
import com.test.ssm.pojo.Menu;
import com.test.ssm.service.AdminUserService;
import com.test.ssm.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SystemController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("login.html")
    public String login() {
        return "login";
    }
    @RequestMapping("logout.html")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @RequestMapping("dologin.html")
    public ModelAndView login(String email, String password, HttpSession session) {
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(email,password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new ModelAndView("login", "message", "用户名或密码错误");
        }
        System.out.println("成功=================");
        int id = Integer.parseInt(subject.getPrincipal().toString());

        AdminUser adminUser = adminUserService.getUserById(id);
        session.setAttribute("adminUser",adminUser);

        return new ModelAndView(new RedirectView("index.html"));
    }

    @RequestMapping("index.html")
    public String index() {
        return "index";
    }
    @RequestMapping("auth_error.html")
    public String error() {
        return "error";
    }

    @RequestMapping("side.html")
    @ResponseBody
    public List<Menu> getMenuTree() {
        Subject subject=SecurityUtils.getSubject();
        return menuService.getUserMenu(Integer.parseInt(subject.getPrincipal().toString()));
    }
}
