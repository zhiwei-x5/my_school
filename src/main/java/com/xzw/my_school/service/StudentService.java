package com.xzw.my_school.service;

import com.github.pagehelper.PageInfo;
import com.xzw.my_school.pojo.Student;

public interface StudentService {
    void addStudent(Student student,Integer tid);

    PageInfo selStudent(Integer pageNum, Integer pageSize);
    PageInfo selStudentByTeacher(Integer pageNum, Integer pageSize,String name);

}
