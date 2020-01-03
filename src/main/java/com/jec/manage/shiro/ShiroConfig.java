package com.jec.manage.shiro;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/common/**","anon");
        filterMap.put("/login.html","anon");
        filterMap.put("/**.html", "authc");
        filterMap.put("/login","anon");
        filterMap.put("/tologin","anon");
        filterMap.put("/logout","logout");//配置退出 过滤器,其中的具体的退出代码Shiro已经实现
        filterMap.put("/**","authc");//过滤链定义，从上向下顺序执行，一般将/**放在最为下边
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }




    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(customRealm());
        return defaultSecurityManager;
    }
    @Bean
    public CustonRealm customRealm() {
        CustonRealm custonRealm = new CustonRealm();
        return custonRealm;
    }
   /* *//**
     * 用于thymeleaf模板使用shiro标签
     * @return
     *//*
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }*/
}
