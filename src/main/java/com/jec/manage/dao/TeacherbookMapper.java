package com.jec.manage.dao;

import com.jec.manage.bean.Teacherbook;
import com.jec.manage.bean.TeacherbookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherbookMapper {


    List<Teacherbook> selectBook();

    long countByExample(TeacherbookExample example);

    int deleteByExample(TeacherbookExample example);

    int insert(Teacherbook record);

    int insertSelective(Teacherbook record);

    List<Teacherbook> selectByExample(TeacherbookExample example);

    int updateByExampleSelective(@Param("record") Teacherbook record, @Param("example") TeacherbookExample example);

    int updateByExample(@Param("record") Teacherbook record, @Param("example") TeacherbookExample example);
}