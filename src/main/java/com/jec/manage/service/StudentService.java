package com.jec.manage.service;

import com.jec.manage.LogAspect.LogsAnno;
import com.jec.manage.bean.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.relational.core.sql.In;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentService {
    Map deleteStudentId(Integer id);

    Map updateinfo(Integer id,String name, int learntime, String classid, String teachername, Date opendate);
    List<Student> selectClassId(String classId);

    Map selectStudent( Integer page, Integer rows,String name);

    int updateLearn(Integer learntime, Integer id);

    Student selectId(Integer id);

    List<Student> selectBook(String classId);

    int updateStudentTime(Integer id, Integer learntime);
    int insertSelective(String name, int learntime, String classid, String teachername, Date opendate);
}
