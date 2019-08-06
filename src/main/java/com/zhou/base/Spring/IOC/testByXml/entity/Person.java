package com.zhou.base.Spring.IOC.testByXml.entity;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/8/1 15:18
 */
public class Person {

    private Student student;
    private Teacher teacher;

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
