package com.jec.manage.dao;

import com.jec.manage.bean.Classform;
import com.jec.manage.bean.ClassformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassformMapper {
    List<Classform> selectform();
    List<Classform> selectList(@Param("teachername") String teachername);


    long countByExample(ClassformExample example);

    int deleteByExample(ClassformExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Classform record);

    int insertSelective(Classform record);

    List<Classform> selectByExample(ClassformExample example);

    Classform selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Classform record, @Param("example") ClassformExample example);

    int updateByExample(@Param("record") Classform record, @Param("example") ClassformExample example);

    int updateByPrimaryKeySelective(Classform record);

    int updateByPrimaryKey(Classform record);
}