package com.jec.manage.controller;

import com.jec.manage.bean.Admin;
import com.jec.manage.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class loginController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/hour")
    @ResponseBody
    public String toHour(){
        return "hour.html";
    }

    @RequestMapping("/pupil")
    @ResponseBody
    public String toPupil(){
        System.out.println("输出一次");
        return "pupil.html";
    }

   @RequestMapping("/tologin")
   @ResponseBody
    public Map selectLogin(@Param("username")String username, @Param("password") String password ){
       HashMap<String, String> map = new HashMap<>();
       Subject subject = SecurityUtils.getSubject();
       UsernamePasswordToken token = new UsernamePasswordToken(username,password);
       try {
           subject.login(token);
           System.out.println("token============="+token);
           //登录成功
           //跳转到test.html

           map.put("code","200");
           map.put("msg","登陆成功");
           return map;
       } catch (UnknownAccountException e) {
           //e.printStackTrace();
           //登录失败:用户名不存在
           map.put("code","500");
           map.put("msg","用户名不存在");
           return map;
       }catch (IncorrectCredentialsException e) {
           //e.printStackTrace();
           //登录失败:密码错误
           map.put("code","500");
           map.put("msg","密码错误");
           return map;
       }
   }
}
