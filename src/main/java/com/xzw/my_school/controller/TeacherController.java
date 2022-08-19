package com.xzw.my_school.controller;

import com.xzw.my_school.pojo.Teacher;
import com.xzw.my_school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teahcer")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //添加老师信息
    @RequestMapping("add")
    public void add(Integer id,String sub,String name) {
       Teacher teacher =new Teacher();
       teacher.setTId(id);
       teacher.setTSubject(sub);
       teacher.setTName(name);
        teacherService.addTeacher(teacher);
    }
    //删除老师信息
    @RequestMapping("del")
    public void del(String name) {
        System.out.println(name);
        teacherService.delTeacher(name);
    }
}
