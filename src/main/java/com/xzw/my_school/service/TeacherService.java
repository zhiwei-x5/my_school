package com.xzw.my_school.service;

import com.xzw.my_school.pojo.Teacher;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    /**
     * 添加老师
     */
    void addTeacher(Teacher teacher);
    void delTeacher(String name);
}
