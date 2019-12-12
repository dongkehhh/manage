package com.jec.manage.controller;

import com.jec.manage.bean.Teacherbook;
import com.jec.manage.service.TeacherbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class teacherbookController {
    @Autowired
    TeacherbookService teacherbookService;
    @RequestMapping("select1")
    @ResponseBody
    public List<Teacherbook> select(){
        List<Teacherbook> teacherbooks = teacherbookService.selectBook();
        return teacherbooks;
    }
}
