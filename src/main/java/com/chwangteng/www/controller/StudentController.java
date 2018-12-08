package com.chwangteng.www.controller;


import com.chwangteng.www.Utils.ConstVar;
import com.chwangteng.www.param.*;
import com.chwangteng.www.pojo.StudentExample;
import com.chwangteng.www.pojo.TeacherExample;
import com.chwangteng.www.service.StudentService;
import com.chwangteng.www.mapper.StudentMapper;
import com.chwangteng.www.pojo.Student;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentService studentService;

    //老师新增学生，从session获取teacherid
    @RequestMapping("/addStudent.action")
    public ModelAndView addStudent(@RequestBody AddStudentRequestParam addStudentRequestParam, HttpSession session)   {

        int userid = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_ID_).toString());

        Student student = new Student();
        student.setSex(addStudentRequestParam.getSex());
        student.setTelephone(addStudentRequestParam.getTelephone());
        student.setMail(addStudentRequestParam.getMail());
        student.setName(addStudentRequestParam.getName());
        student.setUsername(addStudentRequestParam.getUsername());
        student.setTeacherId(userid);
        int size = addStudentRequestParam.getUsername().length();

        String last6 = addStudentRequestParam.getUsername().substring(size-6);

        student.setPassword(last6);

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

    //删除学生
    @RequestMapping("/deleStudent.action")
    public ModelAndView deleteStudent(@RequestBody DeleteStudentParam deleteStudentParam){
        int rows = studentMapper.deleteByPrimaryKey(deleteStudentParam.getId());
        if(rows==1){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_MESSAGE_, "删除学生成功");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "未知错误，删除学生失败");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

    //学生修改自己的密码
    @RequestMapping("/updateMyPassword.action")
    public ModelAndView updateMyPassword(@RequestBody StudentUpdateMyPasswordParam studentUpdateMyPasswordParam, HttpSession session)   {

        int userid = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_ID_).toString());
        int usertype = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_TYPE_).toString());
        if(usertype==ConstVar._STUDENT_){
            int rows = studentService.updateMyPassword(userid,
                    studentUpdateMyPasswordParam.getPassword());
            if(rows==1){
                Map<String,Object> map = new HashMap<String,Object>();
                map.put(ConstVar._KEY_MESSAGE_, "密码已修改");
                return new ModelAndView(new MappingJackson2JsonView(),map);
            }else if(rows==ConstVar._ERROR_NOTFOUND){
                Map<String,Object> map = new HashMap<String,Object>();
                map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
                map.put(ConstVar._KEY_MESSAGE_, "不存在该学生");
                return new ModelAndView(new MappingJackson2JsonView(),map);
            }else{
                Map<String,Object> map = new HashMap<String,Object>();
                map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
                map.put(ConstVar._KEY_MESSAGE_, "未知错误，修改失败");
                return new ModelAndView(new MappingJackson2JsonView(),map);
            }
        }
        else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "不是学生");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

    //查找学生信息
    @RequestMapping("/selectTeacher.action")
    public ModelAndView selectTeacher(@RequestBody SelectStudentRequestParam selectStudentRequestParam){

        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria();

        //需要返回resultList和itemsCount
        List records = studentMapper.selectByExample(studentExample);

        if(records.size()!=0){
            ModelAndView mv = new ModelAndView();
            mv.addObject(ConstVar._KEY_DATA_,records);
            mv.setView(new MappingJackson2JsonView());
            return mv;
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
            map.put(ConstVar._KEY_MESSAGE_, "没有找到学生");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

    //更新学生信息
    @RequestMapping("/updateStudentInfo.action")
    public ModelAndView updateStudentInfo(@RequestBody UpdateStudentRequestParam updateStudentRequestParam, HttpSession session){

        Student student = new Student();
        student.setId(updateStudentRequestParam.getId());
        student.setMail(updateStudentRequestParam.getMail());
        student.setName(updateStudentRequestParam.getName());
        student.setSex(updateStudentRequestParam.getSex());
        student.setTelephone(updateStudentRequestParam.getTelephone());

        int rows = studentMapper.updateByPrimaryKeySelective(student);
        if(rows==1){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_MESSAGE_, "更新成功");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
            map.put(ConstVar._KEY_MESSAGE_, "更新失败");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }
}
