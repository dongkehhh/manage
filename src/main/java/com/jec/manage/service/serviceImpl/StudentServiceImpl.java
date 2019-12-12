package com.jec.manage.service.serviceImpl;

import com.jec.manage.bean.Student;
import com.jec.manage.dao.StudentMapper;
import com.jec.manage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentMapper StudentMapper;

    @Override
    public List<Student> selectStudent(String name) {
        return StudentMapper.selectStudent(name);
    }

    @Override
    public int updateLearn(int learntime, int id) {
        return StudentMapper.updateLearn(learntime,id);
    }

    @Override
    public List<Student> selectBook(String classId) {
        List<String> list = new ArrayList<>();
        System.out.println(classId);
        List<Student> students = StudentMapper.selectBook(classId);
        return students;
    }
}
