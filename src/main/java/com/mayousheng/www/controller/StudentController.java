package com.mayousheng.www.controller;


import com.mayousheng.www.Utils.ConstVar;
import com.mayousheng.www.mapper.StudentMapper;
import com.mayousheng.www.mapper.TeacherMapper;
import com.mayousheng.www.param.AddStudentRequestParam;
import com.mayousheng.www.param.AddTeacherRequestParam;
import com.mayousheng.www.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    //新增学生
    @RequestMapping("/addStudent.action")
    public ModelAndView addTeacher(@RequestBody AddStudentRequestParam addStudentRequestParam)   {
        Student student = new Student();
        student.setSex(addStudentRequestParam.getSex());
        student.setTelephone(addStudentRequestParam.getTelephone());
        student.setMail(addStudentRequestParam.getMail());
        student.setName(addStudentRequestParam.getName());
        student.setTeacherId(addStudentRequestParam.getTeacherId());
        student.setPassword(addStudentRequestParam.getPassword());
        int rows = studentMapper.insertSelective(student);
        if(rows==1){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_MESSAGE_, "新增学生成功");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "未知错误，新增学生失败");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

}
