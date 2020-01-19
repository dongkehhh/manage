package com.jec.manage.service.serviceImpl;

import com.jec.manage.bean.Admin;
import com.jec.manage.bean.Classform;
import com.jec.manage.bean.Logs;
import com.jec.manage.dao.ClassformMapper;
import com.jec.manage.service.ClassformService;
import com.jec.manage.service.LogsService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ClassformServiceImpl implements ClassformService {
    @Autowired
    ClassformMapper  classformMapper;

    @Autowired
    LogsService logsService;
    @Override
    public List<Classform> selectform() {
        return classformMapper.selectform();
    }

    @Override
    public List selectList(String teachername) {
        List<String> list=new ArrayList<>();
        System.out.println(teachername);
        List<Classform> classforms = classformMapper.selectList(teachername);
        System.out.println(classforms);
        for (Classform c:classforms) {
            list.add(c.getClassid());
        }
        return list;
    }

    @Override
    public Integer insertclass(Integer id, String classId, String teachername, String teacherid) {
        Classform classform = new Classform();
        classform.setId(id);
        System.out.println("classform"+classform);
        classform.setClassid(classId);
        classform.setTeachername(teachername);
        classform.setTeacherid(teacherid);
        int i = classformMapper.insertSelective(classform);
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        Logs logs1 = new Logs();
        logs1.setUsername(admin.getUsername());
        logs1.setParams("班级id: "+id+"班级名称: "+classId+"所属教师: "+teachername+"教师id: "+teacherid);
        logs1.setOperation("增加班级信息");
        logs1.setTypeone(2);
        if (i==1){
            logs1.setAtmtype("操作成功");
            System.out.println("增加班级信息成功");
        }else {
            logs1.setAtmtype("操作失败");
        }
        Integer integer = logsService.insertLogs(logs1);
        return i;
    }

    @Override
    public Integer updateclass(Integer id, String classId, String teachername, String teacherid) {
        Classform classform = new Classform();
        classform.setId(id);
        classform.setClassid(classId);
        classform.setTeachername(teachername);
        classform.setTeacherid(teacherid);
        int i = classformMapper.updateByPrimaryKeySelective(classform);
        Logs logs1 = new Logs();
        logs1.setCreatedtime(new Date());
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        logs1.setUsername(admin.getUsername());
        logs1.setParams("班级id: "+id+"班级名称: "+classId+"所属教师: "+teachername+"教师id: "+teacherid);
        logs1.setOperation("修改班级信息");
        logs1.setTypeone(2);
        if (i==1){
            logs1.setAtmtype("操作成功");
            System.out.println("修改班级信息");
        }else {
            logs1.setAtmtype("操作失败");
        }
        Integer integer = logsService.insertLogs(logs1);
        return i;
    }
}
