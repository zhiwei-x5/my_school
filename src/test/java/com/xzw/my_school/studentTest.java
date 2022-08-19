package com.xzw.my_school;

import com.xzw.my_school.mapper.UserMapper;
import com.xzw.my_school.pojo.Student;
import com.xzw.my_school.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class studentTest {
    @Autowired
    private UserMapper userMapper;


    @Test
    public void addUserByStudent(){
        Student student = new Student(1012,"赵六",Date.valueOf("2022-8-19"),"男");

        //查询判断是否有重名
        int rep=userMapper.selUserByStudent_repetition("赵六");
        if (rep != 0){
            userMapper.addUserByClass(1,1001);
        }
        //查询class是否已经配有老师，有则查到的值不为0
        int exe=userMapper.selUserByStudent(1001);

        try{
            if(exe != 0){
            int res =userMapper.addUserByStudent(student);
                System.out.println(res);
            }
        }catch (Exception e){
            System.out.println("学生名字重复，请重新输入！");
        }
    }
}
