package com.bdqn.dao;

import com.bdqn.entity.Tuser3;

import java.util.List;

/**
 * Created by 佳 on 2017/12/7.
 */
public interface TuserMapper3 {
    public Tuser3 login(Tuser3 tuser3);

    public List<Tuser3> queryAll();
}
