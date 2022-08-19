package com.xzw.my_school.pojo;


import lombok.Data;

import java.sql.Date;

@Data
public class Student {
    private Integer sNo;
    private String sName;
    private Date birthday;
    private String sex;
    public Student(){

    }
    public Student(Integer sNo, String sName, Date birthday, String sex) {
        this.sNo = sNo;
        this.sName = sName;
        this.birthday = birthday;
        this.sex = sex;
    }

}
