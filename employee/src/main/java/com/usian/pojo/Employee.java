package com.usian.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

public class Employee {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer sex;
    private Integer code;
    private String starttime;
    private String endtime;

    public Employee() {
    }

    public Employee(Integer id, String name, Integer age, Date birthday, Integer sex, Integer code) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.sex = sex;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", code=" + code +
                '}';
    }
}
