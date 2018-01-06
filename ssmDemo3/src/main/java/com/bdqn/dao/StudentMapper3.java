package com.bdqn.dao;

import com.bdqn.entity.Student3;

import java.util.List;

/**
 * Created by 佳 on 2017/12/15.
 */
public interface StudentMapper3 {
    public List<Student3> queryAll();

    public Integer deleteStudentByIds(List<Integer> list);

    public Integer addStudent(Student3 student3);

    public Integer updateStudent(Student3 student3);

    public Student3 queryStudentById(Integer id);

    public List<Student3> queryStudentByGradeId(Integer gradeId);
}
