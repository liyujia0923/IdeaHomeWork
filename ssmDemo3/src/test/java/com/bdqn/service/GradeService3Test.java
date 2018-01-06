package com.bdqn.service;

import com.bdqn.entity.Grade3;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GradeService3Test {
    @Resource
    private  GradeService3 gradeService3;
    @Test
    public void testQueryAll() {
        PageInfo<Grade3> pageInfo = gradeService3.queryAll(1, 2);
        List<Grade3> list = pageInfo.getList();
        for (Grade3 grade3 : list) {
            System.out.println(grade3);
        }
    }


}