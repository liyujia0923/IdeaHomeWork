package com.bdqn.service;

import com.bdqn.entity.Grade3;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 佳 on 2017/12/9.
 */
public interface GradeService3 {
    public PageInfo<Grade3> queryAll(Integer pageNum, Integer pageSize);


    public Grade3 queryGradeById(Integer id);

    public Integer deleteGradeById(Integer id);

    public Integer deleteGradeByIds(List<Integer> list);

    public Integer addGrade(Grade3 grade3);

    public Integer updateGrade(Grade3 grade3);

    public List<Grade3> queryAll();
}
