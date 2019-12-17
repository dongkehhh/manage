package com.jec.manage.dao;

import com.jec.manage.bean.Student;
import com.jec.manage.bean.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    Student  selectId(@Param("id") int id);

    int updateStudentTime(Student student);

    List<Student>  selectClassId(@Param("classId") String classId);

    List<Student> selectStudent(@Param("name") String name);

    int updateLearn(int learntime,int id);

    List<Student> selectBook(@Param("classId") String classId);

    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}