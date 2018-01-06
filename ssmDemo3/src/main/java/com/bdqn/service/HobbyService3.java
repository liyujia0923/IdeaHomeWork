package com.bdqn.service;

import com.bdqn.entity.Hobby3;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 佳 on 2017/12/28.
 */
public interface HobbyService3 {
    PageInfo<Hobby3> queryAll(Integer pageNum, Integer pageSize);

    Integer addHobby3(Hobby3 hobby3);

    Integer deleteHobby(Integer id);

    Integer deleteHobbyList(List<Integer> ids);

    Hobby3 queryHobby(Integer id);

    Integer updateHobby(Hobby3 hobby3);
}
