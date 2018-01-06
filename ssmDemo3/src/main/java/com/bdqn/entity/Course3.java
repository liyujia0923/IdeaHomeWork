package com.bdqn.entity;

/**
 * Created by 佳 on 2018/1/5.
 */
public class Course3 {
    /**
     *
     FieldTypeComment
     idint(11) NOT NULL课程id
     course_namevarchar(10) NULL课程名称
     */
    private Integer id;
    private String courseName;

    @Override
    public String toString() {
        return "Course3{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
