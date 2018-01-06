package com.bdqn.service;

import com.bdqn.dao.ScoreMapper3;
import com.bdqn.entity.Score3;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2018/1/5.
 */
@Service
public class ScoreService3Impl implements ScoreService3 {
    @Resource
    private ScoreMapper3 scoreMapper3;
    @Override
    public PageInfo<Score3> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Score3> list = scoreMapper3.queryAll();
        PageInfo<Score3> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Score3> queryScore(Integer pageNum, Integer pageSize, Integer gradeId, Integer studentId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Score3> list = scoreMapper3.queryScore(gradeId, studentId);
        PageInfo<Score3> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer deleteScoreById(Integer id) {
        return scoreMapper3.deleteScoreById(id);
    }

    @Override
    public Integer deleteScoreByIdList(List<Integer> list) {
        return scoreMapper3.deleteScoreByIdList(list);
    }

    @Override
    public Score3 queryScoreById(Integer id) {
        return scoreMapper3.queryScoreById(id);
    }
}
