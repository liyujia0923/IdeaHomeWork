package com.bdqn.service;

import com.bdqn.dao.GradeMapper3;
import com.bdqn.dao.StudentNumMapper3;
import com.bdqn.entity.Grade3;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/9.
 */
@Service
public class GradeService3Impl implements GradeService3 {
    @Resource
    private GradeMapper3 gradeMapper3;
    @Resource
    private StudentNumMapper3 studentNumMapper3;
    @Override
    public PageInfo<Grade3> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Grade3> list = gradeMapper3.queryAll();
        PageInfo<Grade3> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Grade3 queryGradeById(Integer id) {
        return gradeMapper3.queryGradeById(id);
    }

    @Override
    public Integer deleteGradeById(Integer id) {
        return gradeMapper3.deleteGradeById(id);
    }

    @Override
    public Integer deleteGradeByIds(List<Integer> list) {
        return gradeMapper3.deleteGradeByIds(list);
    }

    @Override
    public Integer addGrade(Grade3 grade3) {
        gradeMapper3.addGrade(grade3);
        Integer gradeId = grade3.getId();
        return studentNumMapper3.addStudentNum(gradeId);
    }

    @Override
    public Integer updateGrade(Grade3 grade3) {
        return gradeMapper3.updateGrade(grade3);
    }

    @Override
    public List<Grade3> queryAll() {
        return gradeMapper3.queryAll();
    }
}
