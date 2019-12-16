package com.jec.manage.controller;

import com.jec.manage.service.ClassformService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassformController {
    @Autowired
    ClassformService classformService;
    @RequestMapping("page/list")
    public List selectList(@Param("teachername") String teachername){
        return classformService.selectList(teachername);
    }
}
