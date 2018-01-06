package com.bdqn.service;

import com.bdqn.dao.TuserMapper3;
import com.bdqn.entity.Tuser3;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/7.
 */
@Service("tuserService")
public class TuserService3Impl implements TuserService3 {
    @Resource
    private TuserMapper3 tuserMapper3;
    @Override
    public Tuser3 login(Tuser3 tuser3) {

        return tuserMapper3.login(tuser3);
    }

    @Override
    public PageInfo<Tuser3> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Tuser3> list = tuserMapper3.queryAll();
        PageInfo<Tuser3> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
