package com.xzw.my_school.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzw.my_school.mapper.UserMapper;
import com.xzw.my_school.pojo.Student;
import com.xzw.my_school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addStudent(Student student,Integer tid) {
        //查询判断是否有重名
        int rep=userMapper.selUserByStudent_repetition(student.getSName());
        //如果不重名即返回0，然后class加入老师
        System.out.println("rep:"+rep);
        if (rep == 0){
            userMapper.addUserByClass(tid,student.getSNo());
        }
        //查询class是否已经配有老师，有则查到的值不为0
        int exe=userMapper.selUserByStudent(student.getSNo());
        System.out.println("exe:"+exe);
        try{
            if(exe != 0){
                int res =userMapper.addUserByStudent(student);
                System.out.println("添加学生成功："+student.getSName());
                System.out.println(res);
            }else {
                System.out.println("学生名字重复  或者 未分配老师，请重新输入！");
            }
        }catch (Exception e){
            System.out.println("学生名字重复  或者 未分配老师，请重新输入！");
        }
    }
    @Override
    public PageInfo selStudent(Integer pageNum, Integer pageSize) {
        //分页工具，访问传入该页数，每页最大数
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list= userMapper.selUserByAllstudent();
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);
        System.out.println(page);
        return page;
    }

    @Override
    public PageInfo selStudentByTeacher(Integer pageNum, Integer pageSize, String name) {
        int tid=userMapper.selUserByTeacherName(name);
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list= userMapper.selUserByAllstudent_teacher(tid);
        PageInfo page = new PageInfo(list);
        System.out.println(page);
        return page;
    }
}
