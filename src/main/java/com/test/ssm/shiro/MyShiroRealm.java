package com.test.ssm.shiro;

import com.test.ssm.dao.AdminUserDAO;
import com.test.ssm.dao.MenuDAO;
import com.test.ssm.pojo.AdminUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private AdminUserDAO adminUserDAO;


    //请求一个资源的时候使用，比如访问某一个url
    //返回用的权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("doGetAuthorizationInfo===========");
        Integer userId = Integer.parseInt(principalCollection.getPrimaryPrincipal().toString());
        //查询出用所有的角色，交给shiro
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Integer> roleIds = adminUserDAO.getUserRoleIds(userId);
        for (Integer roleId : roleIds) {
            info.addRole(roleId.toString());
        }
        return info;
    }

    //登陆的时候使用，验证用户名密码
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String email = token.getUsername();//登陆时的用户名
        AdminUser user = adminUserDAO.getUserByEmail(email);
        if (user == null) {//用户名错误
            return null;
        }
        return new SimpleAuthenticationInfo(user.getId(), user.getPassword(), super.getName());
    }
}
