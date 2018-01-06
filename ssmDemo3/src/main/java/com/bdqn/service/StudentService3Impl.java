package com.bdqn.service;

import com.bdqn.dao.StudentMapper3;
import com.bdqn.dao.StudentNumMapper3;
import com.bdqn.entity.Student3;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/15.
 */
@Service
public class StudentService3Impl implements StudentService3 {
    @Resource
    private StudentMapper3 studentMapper3;
    @Resource
    private StudentNumMapper3 studentNumMapper3;
    @Override
    public PageInfo<Student3> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student3> list = studentMapper3.queryAll();
        PageInfo<Student3> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer deleteStudentByIds(List<Integer> list) {
        return studentMapper3.deleteStudentByIds(list);
    }

    @Override
    public Integer addStudent(Student3 student3) {
        Integer gradeId = student3.getGrade3().getId();
        studentNumMapper3.updateMaxNumByGradeId(gradeId);
        Integer maxNum = studentNumMapper3.queryMaxNumByGradeId(gradeId);
        String gradeName = student3.getGrade3().getGradeName();
        String studentNum = gradeName + maxNum;
        int n = 15 - studentNum.length();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                gradeName += 0;
            }
        }
        studentNum = gradeName + maxNum;
        student3.setStudentNum(studentNum);

        return studentMapper3.addStudent(student3);
    }

    @Override
    public Integer updateStudent(Student3 student3) {
        return studentMapper3.updateStudent(student3);
    }

    @Override
    public Student3 queryStudentById(Integer id) {
        return studentMapper3.queryStudentById(id);
    }

    @Override
    public List<Student3> queryStudentByGradeId(Integer gradeId) {
        return studentMapper3.queryStudentByGradeId(gradeId);
    }
}
