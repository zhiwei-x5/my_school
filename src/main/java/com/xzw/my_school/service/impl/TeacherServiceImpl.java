package com.xzw.my_school.service.impl;

import com.xzw.my_school.mapper.UserMapper;
import com.xzw.my_school.pojo.Teacher;
import com.xzw.my_school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addTeacher(Teacher teacher) {
        try{
            int  res =userMapper.addUserByTeacher(teacher);
            System.out.println("添加成功："+teacher.getTName());
            System.out.println(res);
        }catch (Exception e){
            System.out.println("老师名字重复，请重新输入！");
        }
    }
    @Override
    public void delTeacher(String name) {
        try{
            //搜索需要删除老师的id
            int res1 = userMapper.selUserByTeacherName(name);
            //删除class中老师的信息，以确保学生没有该老师
            userMapper.delUserByClassTeacher(res1);
            //查询class中是否还存有老师的id，如果有返回的是总数
            int res3 = userMapper.selUserByClassTeacherId(res1);
            if(res3 == 0){
                userMapper.delUserByTeacher(name);
                System.out.println("删除成功！");
            }
        }catch (Exception e){
            System.out.println("不存在该老师！");
        }
    }
}
