package com.jec.manage.controller;

import com.jec.manage.bean.Classform;
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

    @RequestMapping("form")
    List<Classform> selectform(){
        return  classformService.selectform();
    }
    @RequestMapping("list")
    public List selectList(@Param("teachername") String teachername){
        return classformService.selectList(teachername);
    }
    @RequestMapping("updateclass")
    public Integer updateclass(Integer id, String classId, String teachername, String teacherid) {
        return  classformService.updateclass(id, classId, teachername, teacherid);
    }
    @RequestMapping("insertclass")
    public Integer insertclass(Integer id, String classId, String teachername, String teacherid){
        return classformService.insertclass(id, classId, teachername, teacherid);
    }
}
