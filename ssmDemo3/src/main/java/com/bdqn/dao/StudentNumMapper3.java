package com.bdqn.dao;

/**
 * Created by 佳 on 2017/12/16.
 */
public interface StudentNumMapper3 {
    public Integer addStudentNum(Integer gradeId);

    public Integer updateMaxNumByGradeId(Integer gradeId);

    public Integer queryMaxNumByGradeId(Integer gradeId);
}
