package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Grade3;
import com.bdqn.service.GradeService3;
import com.bdqn.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 佳 on 2017/12/9.
 */
@Controller
@RequestMapping("grade")
public class GradeController3 {
    @Resource
    private GradeService3 gradeService3;

    @RequestMapping("toGrade")
    public String toGrade(Integer pageNum, Integer pageSize, Model model) {
        PageInfo<Grade3> pageInfo = gradeService3.queryAll(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "grade/grade";
    }

    @ResponseBody
    @RequestMapping(value = "queryGradeById",method = RequestMethod.GET,
    produces = {"application/json;charset=UTF-8"})
    public String queryGradeById(Integer gradeId) {
        Grade3 grade3 = gradeService3.queryGradeById(gradeId);
        return JSON.toJSONString(grade3);
    }
    @ResponseBody
    @RequestMapping(value = "deleteGradeById",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteGradeById(Integer gradeId) {
        Integer n = gradeService3.deleteGradeById(gradeId);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "deleteGradeByIds",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteGradeByIds(String gradeIds) {
        String[] gradeArray = gradeIds.split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (String s : gradeArray) {
            list.add(Integer.parseInt(s));
        }
        int n = gradeService3.deleteGradeByIds(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "addGrade",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String addGrade(Grade3 grade3) {
        int n = gradeService3.addGrade(grade3);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "updateGrade",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String updateGrade(Grade3 grade3) {
        int n = gradeService3.updateGrade(grade3);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
}
