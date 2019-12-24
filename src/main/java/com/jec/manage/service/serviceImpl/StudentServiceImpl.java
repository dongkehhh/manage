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
    public int deleteStudentId(Integer id) {
        return StudentMapper.deleteStudentId(id);
    }

    @Override
    public List<Student> selectClassId(String classId) {
        List<Student> students = StudentMapper.selectClassId(classId);
        return students;
    }

    @Override
    public List<Student> selectStudent(String name) {
        return StudentMapper.selectStudent(name);
    }

    @Override
    public int updateLearn(int learntime, int id) {
        return StudentMapper.updateLearn(learntime,id);
    }

    @Override
    public Student selectId(int id) {
        return StudentMapper.selectId(id);
    }

    @Override
    public List<Student> selectBook(String classId) {
        List<String> list = new ArrayList<>();
        System.out.println(classId);
        List<Student> students = StudentMapper.selectBook(classId);
        return students;
    }

    @Override
    public int updateStudentTime(Integer id, Integer learntime) {
        Student student = new Student();
        student.setId(id);
        student.setLearntime(learntime);
        int i = StudentMapper.updateStudentTime(student);
        return i;
    }
}
