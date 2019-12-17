package com.jec.manage.controller;

import com.github.pagehelper.PageHelper;
import com.jec.manage.bean.Student;
import com.jec.manage.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("page/select")
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("/book")
    public List selectBook(String classId){
        List<Student> strings = studentService.selectBook(classId);
        return strings;
    }
    @RequestMapping("/learn")
    public String updateLearn(@Param("learntime") int learntime,@Param("id") int id) {
        int i = studentService.updateLearn(learntime, id);
        if (i==1){
        return "修改成功";
        }else {
        return "出现未知错误,请联系管理员";
        }
    }
    @RequestMapping("/student")
    public List<Student> selectStudent(Integer page, Integer limit,String name){
        PageHelper.startPage(page,limit);
        return studentService.selectStudent(name);
    }
    @RequestMapping("/classId")
    public List<Student> selectClassId(String classId){
        return studentService.selectClassId(classId);
    }
}
