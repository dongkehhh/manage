package com.jec.manage.service;

import com.jec.manage.bean.Student;

import java.util.List;

public interface StudentService {
    List<Student>  selectClassId(String classId);
    List<Student> selectStudent(String name);
    int updateLearn(int learntime,int id);

    List<Student> selectBook(String classId);
}
