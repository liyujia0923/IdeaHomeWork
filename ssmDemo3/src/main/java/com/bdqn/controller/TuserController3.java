package com.bdqn.controller;

import com.bdqn.entity.Tuser3;
import com.bdqn.service.TuserService3;
import com.bdqn.util.Comm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by 佳 on 2017/12/7.
 */
@Controller
@RequestMapping("user")
public class TuserController3 {

    @Resource
    private TuserService3 tuserService3;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(Tuser3 tuser3, HttpSession session, Model model) {
        Tuser3 loginUser = tuserService3.login(tuser3);
        if (null != loginUser) {
            session.setAttribute(Comm.LOGIN_USER,loginUser);
            return "comm/main";
        }
        model.addAttribute("message", "用户名或密码错误！");
        return "index";
    }

    @RequestMapping(value = "loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("loginUser");
        return "index_bookstrap";
    }
}
