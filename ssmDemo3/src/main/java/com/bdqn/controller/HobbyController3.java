package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Hobby3;
import com.bdqn.service.HobbyService3;
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
@RequestMapping("hobby")
public class HobbyController3 {

    @Resource
    private HobbyService3 hobbyService3;
    @RequestMapping(value = "toHobby")
    public String toHobby() {
        return "hobby/hobby";
    }

    @ResponseBody
    @RequestMapping(value = "queryAll", method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryAll(Integer page, Integer rows) {
        PageInfo<Hobby3> pageInfo = hobbyService3.queryAll(page, rows);
     /*   Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());*/
        PageUtil<Hobby3> pageUtil = new PageUtil<>(pageInfo);
        return JSON.toJSONString(pageUtil);
    }

    @ResponseBody
    @RequestMapping(value = "addHobby",method = RequestMethod.POST,
    produces = {"application/json;charset=UTF-8"})
    public String addHobby(Hobby3 hobby3) {
        int n = hobbyService3.addHobby3(hobby3);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "deleteHobby",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteHobby(Integer id) {
        int n = hobbyService3.deleteHobby(id);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "deleteHobbyList",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteHobbyList(String ids) {
        String[] idArray = ids.split(",");
        List<Integer> list = new ArrayList<>();
        if (idArray != null || idArray.length > 0) {
            for (String s : idArray) {
                list.add(Integer.parseInt(s));
            }
        }
        int n = hobbyService3.deleteHobbyList(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "queryHobby",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryHobby(Integer id) {
        Hobby3 hobby3 = hobbyService3.queryHobby(id);
        return JSON.toJSONString(hobby3);
    }
    @ResponseBody
    @RequestMapping(value = "updateHobby",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String updateHobby(Hobby3 hobby3) {
        int n = hobbyService3.updateHobby(hobby3);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

}
