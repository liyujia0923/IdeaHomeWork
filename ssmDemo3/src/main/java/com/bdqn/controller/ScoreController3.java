package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Score3;
import com.bdqn.service.ScoreService3;
import com.bdqn.util.Message;
import com.bdqn.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 佳 on 2017/12/26.
 */
@Controller
@RequestMapping("score")
public class ScoreController3 {

    @Resource
    private ScoreService3 scoreService3;
    @RequestMapping(value = "toScore")
    public String toScore() {
        return "score/score";
    }

    @ResponseBody
    @RequestMapping(value = "queryAll",method = RequestMethod.GET,
    produces = {"application/json;charset=UTF-8"})
    public String queryAll(Integer page,Integer rows,
                           Integer gradeId,Integer studentId){
      /*  PageInfo<Score3> pageInfo = scoreService3.queryAll(page, rows);
        PageUtil<Score3> pageUtil = new PageUtil<>(pageInfo);
        return JSON.toJSONString(pageUtil);*/
      if (null!=gradeId &&gradeId==-1){
          gradeId = null;
      }
      if(studentId!=null && studentId == -1){
          studentId = null;
      }
        PageInfo<Score3> pageInfo = scoreService3.queryScore(page, rows, gradeId, studentId);
        PageUtil<Score3> pageUtil = new PageUtil<>(pageInfo);
        return JSON.toJSONString(pageUtil);
    }
    @ResponseBody
    @RequestMapping(value = "deleteScoreById",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteScoreById(Integer id) {
        int n = scoreService3.deleteScoreById(id);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "deleteScoreByList",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteScoreByList(String ids) {
        String[] idArray = ids.split(",");
        List<Integer> list = new ArrayList<>();
        if (idArray != null && idArray.length > 0) {
            for (String s : idArray) {
                list.add(Integer.parseInt(s));
            }
        }
        int n = scoreService3.deleteScoreByIdList(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "queryScoreById",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryScoreById(Integer id) {
        Score3 score3 = scoreService3.queryScoreById(id);
        return JSON.toJSONString(score3);
    }
}
