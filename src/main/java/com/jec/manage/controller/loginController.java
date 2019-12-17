package com.jec.manage.controller;

import com.jec.manage.bean.Admin;
import com.jec.manage.service.AdminService;
import org.apache.ibatis.annotations.Param;
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

   @RequestMapping("page/login")
   @ResponseBody
    public Map selectLogin(@Param("username")String username, @Param("password") String password ){
       System.out.println("username=============================="+username);
       HashMap<String, String> map = new HashMap<>();
       Admin admin = adminService.selectLogin(username);
        if (admin==null){
            map.put("code","500");
            map.put("msg","账户不存在或密码错误");
            return map;
        }
      if (!username.equals(admin.getUsername())){
          map.put("code","500");
          map.put("msg","账户不存在或密码错误");
          return map;
      }
      if (!password.equals(admin.getPassword())){
          map.put("code","500");
          map.put("msg","账户不存在或密码错误");
          return map;
      }
       map.put("code","200");
       map.put("msg","登陆成功");
       return map;
   }
}
