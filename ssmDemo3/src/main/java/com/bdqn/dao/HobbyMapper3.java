package com.bdqn.dao;

import com.bdqn.entity.Hobby3;

import java.util.List;

/**
 * Created by 佳 on 2017/12/28.
 */
public interface HobbyMapper3 {
    List<Hobby3> queryAll();

    Integer addHobby3(Hobby3 hobby3);

    Integer deleteHobby(Integer id);

    Integer deleteHobbyList(List<Integer> ids);

    Hobby3 queryHobby(Integer id);

    Integer updateHobby(Hobby3 hobby3);
}
