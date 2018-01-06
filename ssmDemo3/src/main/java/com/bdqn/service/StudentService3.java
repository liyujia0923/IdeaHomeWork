package com.bdqn.service;

import com.bdqn.entity.Student3;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 佳 on 2017/12/15.
 */
public interface StudentService3 {
    public PageInfo<Student3> queryAll(Integer pageNum,Integer pageSize);

    public Integer deleteStudentByIds(List<Integer> list);

    public Integer addStudent(Student3 student3);

    public Integer updateStudent(Student3 student3);

    public Student3 queryStudentById(Integer id);

    public List<Student3> queryStudentByGradeId(Integer gradeId);

}
