package com.bdqn.dao;

import com.bdqn.entity.Score3;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 佳 on 2018/1/5.
 */
public interface ScoreMapper3 {
    public List<Score3> queryAll();

    public List<Score3> queryScore(@Param("gradeId") Integer gradeId,
                                   @Param("studentId") Integer studentId);

    public Integer deleteScoreById(Integer id);

    public Integer deleteScoreByIdList(List<Integer> list);

    public Score3 queryScoreById(Integer id);
}
