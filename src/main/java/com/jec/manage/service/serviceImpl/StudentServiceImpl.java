package com.jec.manage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jec.manage.bean.Admin;
import com.jec.manage.bean.Logs;
import com.jec.manage.bean.Student;
import com.jec.manage.dao.StudentMapper;
import com.jec.manage.service.LogsService;
import com.jec.manage.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    LogsService logsService;



    @Override
    public Map deleteStudentId(Integer id) {
        int i = studentMapper.deleteStudentId(id);
        HashMap<String, Boolean> map = new HashMap<>();
        if (i==0){
           map.put("success",false);
        }else {
            map.put("success",true);
        }
        return map;
    }

    @Override
    public Map updateinfo(Integer id,String name, int learntime, String classid, String teachername, Date opendate) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setLearntime(learntime);
        student.setClassid(classid);
        student.setTeachername(teachername);
        student.setOpendate(opendate);
        int i = studentMapper.updateStudentTime(student);
        HashMap<String, Boolean> map = new HashMap<>();
        if (i==0){
            map.put("success",false);
        }else {
            map.put("success",true);
        }

        Logs logs1 = new Logs();
        logs1.setCreatedtime(new Date());
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        logs1.setUsername(admin.getUsername());
        logs1.setParams("学员id: "+id+"学员名称: "+name+"当前课时: "+"班级: "+classid+"所属教师: "+teachername);
        logs1.setOperation("修改学员信息");
        logs1.setTypeone(2);
        if (i==1){
            logs1.setAtmtype("操作成功");
        }else {
            logs1.setAtmtype("操作失败");
        }
        Integer integer = logsService.insertLogs(logs1);




        return map;
    }

    @Override
    public List<Student> selectClassId(String classId) {
        List<Student> students = studentMapper.selectClassId(classId);
        return students;
    }


    @Override
    public Map selectStudent( Integer page, Integer rows,String name) {
        PageHelper.startPage(page,rows);
        HashMap<Object, Object> map = new HashMap<>();
        List<Student> rows1 = studentMapper.selectStudent(name);
        //PageInfo封装了数据的所有的分页信息
        PageInfo<Student> pageInfo = new PageInfo<Student>(rows1);
        long total = pageInfo.getTotal();
        System.out.println(total);
        map.put("total",total);
        map.put("rows",rows1);
        return map;
    }

    @Override
    public int updateLearn(Integer learntime, Integer id) {
        int i = studentMapper.updateLearn(learntime, id);
        Logs logs1 = new Logs();
        logs1.setCreatedtime(new Date());
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        logs1.setUsername(admin.getUsername());
        logs1.setParams("学员id"+id+"修改课时数"+learntime);
        logs1.setOperation("修改学员课时");
        logs1.setTypeone(1);
        if (i==1){
            logs1.setAtmtype("操作成功");
        }else {
            logs1.setAtmtype("操作失败");
        }
        Integer integer = logsService.insertLogs(logs1);
        return i;
    }

    @Override
    public Student selectId(Integer id) {
            return studentMapper.selectId(id);
    }

    @Override
    public List<Student> selectBook(String classId) {
        List<String> list = new ArrayList<>();
        List<Student> students = studentMapper.selectBook(classId);
        return students;
    }

    @Override
    public int updateStudentTime(Integer id, Integer learntime) {
        Student student = new Student();
        student.setId(id);
        student.setLearntime(learntime);
        int i = studentMapper.updateStudentTime(student);
        Logs logs1 = new Logs();
        logs1.setCreatedtime(new Date());
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        logs1.setUsername(admin.getUsername());
        logs1.setParams("学员id"+id+"修改课时数"+learntime);
        logs1.setOperation("修改学员课时");
        logs1.setTypeone(1);
        if (i==1){
            logs1.setAtmtype("操作成功");
        }else {
            logs1.setAtmtype("操作失败");
        }
        Integer integer = logsService.insertLogs(logs1);
        return i;
    }

    @Override
    public int insertSelective(String name, int learntime, String classid, String teachername,Date opendate) {
        Student student = new Student();
        student.setName(name);
        student.setLearntime(learntime);
        student.setClassid(classid);
        student.setTeachername(teachername);
        student.setType(0);
        student.setOpendate(opendate);
        int i = studentMapper.insertSelective(student);
        Logs logs1 = new Logs();
        logs1.setCreatedtime(new Date());
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        logs1.setUsername(admin.getUsername());
        String s = name + "," + learntime + "," + classid + "," + teachername;
        logs1.setParams(s);
        logs1.setOperation("增加学员");
        logs1.setTypeone(2);
        if (i==1){
            logs1.setAtmtype("操作成功");
        }else {
            logs1.setAtmtype("操作失败");
        }
        Integer integer = logsService.insertLogs(logs1);
        if (integer ==1){
            System.out.println("增加学员日志记录成功");
        }else {
            System.out.println("增加学员日志记录失败");
        }
        return i;
    }
}
