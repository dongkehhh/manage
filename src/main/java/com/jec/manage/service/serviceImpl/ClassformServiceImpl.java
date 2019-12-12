package com.jec.manage.service.serviceImpl;

import com.jec.manage.bean.Classform;
import com.jec.manage.dao.ClassformMapper;
import com.jec.manage.service.ClassformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ClassformServiceImpl implements ClassformService {
    @Autowired
    ClassformMapper    classformMapper;
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
}
