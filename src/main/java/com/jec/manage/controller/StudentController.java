package com.jec.manage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jec.manage.bean.Student;
import com.jec.manage.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("select")
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("/book")
    public List selectBook(String classId){
        List<Student> strings = studentService.selectBook(classId);
        return strings;
    }
    @RequestMapping("/learn")
    public int updateLearn(@Param("learntime") int learntime,@Param("id") int id) {
        int i = studentService.updateLearn(learntime, id);
        return i;

    }

    @RequestMapping("/student")
    public Map selectStudent(@Param("page") int page,@Param("rows") int rows, String name){
        PageHelper.startPage(page,rows);
        HashMap<Object, Object> map = new HashMap<>();
        List<Student> rows1 = studentService.selectStudent(name);
        //PageInfo封装了数据的所有的分页信息
        PageInfo<Student> pageInfo = new PageInfo<Student>(rows1);
        long total = pageInfo.getTotal();
        map.put("total",total);
        map.put("rows",rows1);
        return map;
    }
    @RequestMapping("/classId")
    public List<Student> selectClassId(String classId){
        return studentService.selectClassId(classId);
    }

    @RequestMapping("/id")
    public Student selectId(int id){
        return studentService.selectId(id);
    }

    @RequestMapping("/insertStudent")
    public int insertSelective(int id,String name, int learntime, String classid, String teachername, Date opendate){
       return studentService.insertSelective(name, learntime, classid, teachername,opendate);
    }

    @RequestMapping("/updateinfo")
    public Map updateinfo(int id,String name, int learntime, String classid, String teachername, Date opendate){
        Map updateinfo = studentService.updateinfo(id, name, learntime, classid, teachername, opendate);
        return updateinfo;
    }

    @RequestMapping("/updateid")
    public Map deleteStudentId(Integer id){
        System.out.println("id==========="+id);
        return studentService.deleteStudentId(id);
    }
}
