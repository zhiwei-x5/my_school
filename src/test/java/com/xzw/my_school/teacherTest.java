package com.xzw.my_school;

import com.xzw.my_school.mapper.UserMapper;
import com.xzw.my_school.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class teacherTest {
    @Autowired
    private UserMapper userMapper;

    //添加老师
    @Test
    public void addUserByTeacherTest(){
        Teacher teacher = new Teacher();
        teacher.setTId(8);
        teacher.setTName("李九");
        teacher.setTSubject("JQ");
        try{
            int  res =userMapper.addUserByTeacher(teacher);
        }catch (Exception e){
            System.out.println("老师名字重复，请重新输入！");
        }
    }
    //删除老师
    @Test
    public void delUserByTeacherTest(){
        int res1 = userMapper.selUserByTeacherName("赵六1");
        userMapper.delUserByClassTeacher(res1);

        //查询class中是否还存有老师的id，如果有返回的是总数
        int res3 = userMapper.selUserByClassTeacherId(res1);
        try{
            if(res3 == 0){
                userMapper.delUserByTeacher("赵六1");
            }
        }catch (Exception e){
            System.out.println("老师还有学生，不能删除！");
        }
    }

}
