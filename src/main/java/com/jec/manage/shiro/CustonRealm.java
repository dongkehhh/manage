package com.jec.manage.shiro;

import com.jec.manage.bean.Admin;
import com.jec.manage.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class CustonRealm extends AuthorizingRealm {
    @Autowired
    AdminService adminService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        Admin admin = adminService.selectLogin(username);
        if (admin!=null){
            SecurityUtils.getSubject().getSession().setAttribute("admin",admin);
            AuthenticationInfo  authcInfo  = new SimpleAuthenticationInfo(admin.getUsername(),admin.getPassword(),"CustonRealm");
            System.out.println("-------身份认证方法--------");
            return authcInfo;
        }else {
            return null;
        }
    }
}
