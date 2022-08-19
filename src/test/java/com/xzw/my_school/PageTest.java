package com.xzw.my_school;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzw.my_school.mapper.UserMapper;
import com.xzw.my_school.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PageTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage() {
        PageHelper.startPage(2,4);
        List<Student> list= userMapper.selUserByAllstudent();
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);
        //测试PageInfo全部属性
        //PageInfo包含了非常全面的分页属性
        System.out.println(page.getPageNum());
        System.out.println(page);
    }
    @Test
    public void testPageTeacher() {
        int tid = userMapper.selUserByTeacherName("张三");
        System.out.println(tid);
        PageHelper.startPage(3,4);
        List<Student> list= userMapper.selUserByAllstudent_teacher(tid);
        PageInfo page = new PageInfo(list);
        System.out.println(page);
    }
}
