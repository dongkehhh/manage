package com.jec.manage.service.serviceImpl;

import com.jec.manage.bean.Teacherbook;
import com.jec.manage.dao.TeacherbookMapper;
import com.jec.manage.service.TeacherbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherbookServiceImpl implements TeacherbookService {

    @Autowired
    TeacherbookMapper teacherbookMapper;

    public  List<Teacherbook> selectBook(){
        return teacherbookMapper.selectBook();
    }
}
