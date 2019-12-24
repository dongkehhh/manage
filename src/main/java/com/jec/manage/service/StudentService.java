package com.jec.manage.service;

import com.jec.manage.bean.Student;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface StudentService {
    int deleteStudentId(Integer id);
    List<Student>  selectClassId(String classId);
    List<Student> selectStudent(String name);
    int updateLearn(int learntime,int id);
    Student  selectId(int id);
    List<Student> selectBook(String classId);
    int updateStudentTime(Integer id,Integer learntime);
}
