package com.bdqn.service;

import com.bdqn.dao.HobbyMapper3;
import com.bdqn.entity.Hobby3;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/28.
 */
@Service
public class HobbyService3Impl implements HobbyService3 {
    @Resource
    private HobbyMapper3 hobbyMapper3;
    @Override
    public PageInfo<Hobby3> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Hobby3> list = hobbyMapper3.queryAll();
        PageInfo<Hobby3> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer addHobby3(Hobby3 hobby3) {
        return hobbyMapper3.addHobby3(hobby3);
    }

    @Override
    public Integer deleteHobby(Integer id) {
        return hobbyMapper3.deleteHobby(id);
    }

    @Override
    public Integer deleteHobbyList(List<Integer> ids) {
        return hobbyMapper3.deleteHobbyList(ids);
    }

    @Override
    public Hobby3 queryHobby(Integer id) {
        return hobbyMapper3.queryHobby(id);
    }

    @Override
    public Integer updateHobby(Hobby3 hobby3) {
        return hobbyMapper3.updateHobby(hobby3);
    }

}
