package com.xzw.my_school.mapper;

import com.xzw.my_school.pojo.Student;
import com.xzw.my_school.pojo.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //添加老师资料
    int addUserByTeacher(Teacher teacher);

    //先添加class表
    int addUserByClass(Integer tid,Integer sid);
    //先查询学生是否有老师
    int selUserByStudent(Integer sno);
    int selUserByStudent_repetition(String name);
    //添加学生信息
    int addUserByStudent(Student student);

    //删除老师
    //先查询class老师工号id
    int selUserByTeacherName(String name);
    //删除class
    int delUserByClassTeacher(Integer tid);
    //查询class是否还有tid
    int selUserByClassTeacherId(Integer tid);
    //如果上面查到为0，则删除
    int delUserByTeacher(String name);

    //查询所有学生进行分页
    List<Student> selUserByAllstudent();
    List<Student> selUserByAllstudent_teacher(Integer tid);

}
