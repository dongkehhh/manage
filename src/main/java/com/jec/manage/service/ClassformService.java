package com.jec.manage.service;

import com.jec.manage.bean.Classform;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface ClassformService {
    List<Classform> selectform();
    List selectList(String teachername);
    Integer insertclass(Integer id,String classId,String teachername,String teacherid);
    Integer updateclass(Integer id,String classId,String teachername,String teacherid);


}
