package com.xzw.my_school.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzw.my_school.pojo.Student;
import com.xzw.my_school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;


@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //添加学生信息
    @RequestMapping("add")
    public void add(Integer sno, String sname, Date bir,String sex,Integer tid) {
        Student student=new Student();
        student.setSNo(sno);
        student.setSName(sname);
        student.setBirthday(bir);
        student.setSex(sex);
        System.out.println("-----------"+student);
        studentService.addStudent(student,tid);
    }

    //查询所有学生，并进行分页
    @RequestMapping("selall")
    public PageInfo sel(Integer pageNum,Integer pageSize) {
        //分页工具，访问传入该页数，每页最大数
        PageInfo pageInfo;
        pageInfo=studentService.selStudent(pageNum,pageSize);
        return pageInfo;
    }

    //查询所有学生并按照指定老师进去分页
    @RequestMapping("selbyteacher")
    public PageInfo sel(Integer pageNum,Integer pageSize,String name) {
        PageInfo pageInfo;
        pageInfo=studentService.selStudentByTeacher(pageNum,pageSize,name);
        return pageInfo;
    }
}
