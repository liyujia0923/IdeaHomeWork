package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bdqn.entity.Grade3;
import com.bdqn.entity.Student3;
import com.bdqn.service.GradeService3;
import com.bdqn.service.StudentService3;
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
 * Created by 佳 on 2017/12/14.
 */
@Controller
@RequestMapping("student")
public class StudentController3 {
    @Resource
    private StudentService3 studentService3;
    @Resource
    private GradeService3 gradeService3;

    @RequestMapping(value = "queryAll")
    public String queryAll(Integer pageNum, Integer pageSize, Model model) {
        PageInfo<Student3> pageInfo = studentService3.queryAll(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "student/student";
    }

    @ResponseBody
    @RequestMapping(value = "deleteStudentByIds",method = RequestMethod.POST,
    produces = {"application/json;charset=UTF-8"})
    public String deleteStudentByIds(String studentId) {
        String[] studentArray = studentId.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : studentArray) {
            list.add(Integer.parseInt(s));
        }
        int n = studentService3.deleteStudentByIds(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "queryGrade",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryGrade() {
        List<Grade3> list = gradeService3.queryAll();
        return JSONArray.toJSONString(list);
    }
    @ResponseBody
    @RequestMapping(value = "addStudent",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String addStudent(Student3 student3) {
        int n = studentService3.addStudent(student3);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "queryStudentById",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryStudentById(Integer id) {
        Student3 student3 = studentService3.queryStudentById(id);
        return JSON.toJSONString(student3);
    }
    @ResponseBody
    @RequestMapping(value = "updateStudent",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String updateStudent(Student3 student3) {
        int n = studentService3.updateStudent(student3);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "queryStudentByGradeId",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryStudentByGradeId(Integer gradeId) {
        List<Student3> list = studentService3.queryStudentByGradeId(gradeId);
        return JSON.toJSONString(list);
    }
}
