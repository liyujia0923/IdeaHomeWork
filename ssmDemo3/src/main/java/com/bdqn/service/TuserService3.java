package com.bdqn.service;

import com.bdqn.entity.Tuser3;
import com.github.pagehelper.PageInfo;

/**
 * Created by 佳 on 2017/12/7.
 */
public interface TuserService3 {
    public Tuser3 login(Tuser3 tuser3);

    public PageInfo<Tuser3> queryAll(Integer pageNum, Integer pageSize);
}
