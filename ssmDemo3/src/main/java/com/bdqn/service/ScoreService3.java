package com.bdqn.service;

import com.bdqn.entity.Score3;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 佳 on 2018/1/5.
 */
public interface ScoreService3 {
    PageInfo<Score3> queryAll(Integer pageNum, Integer pageSize);

    PageInfo<Score3> queryScore(Integer pageNum, Integer pageSize,
                                Integer gradeId, Integer studentId);

    public Integer deleteScoreById(Integer id);

    public Integer deleteScoreByIdList(List<Integer> list);

    public Score3 queryScoreById(Integer id);
}
