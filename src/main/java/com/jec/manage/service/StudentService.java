package com.jec.manage.service;

import com.jec.manage.bean.Student;
import org.springframework.data.relational.core.sql.In;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentService {
    Map deleteStudentId(Integer id);

    Map updateinfo(int id,String name, int learntime, String classid, String teachername, Date opendate);
    List<Student> selectClassId(String classId);

    List<Student> selectStudent(String name);

    int updateLearn(int learntime, int id);

    Student selectId(int id);

    List<Student> selectBook(String classId);

    int updateStudentTime(Integer id, Integer learntime);

    int insertSelective(String name, int learntime, String classid, String teachername, Date opendate);
}
