package com.mayousheng.www.controller;


import com.mayousheng.www.Utils.ConstVar;
import com.mayousheng.www.mapper.TeacherMapper;
import com.mayousheng.www.param.AddLabRequestParam;
import com.mayousheng.www.param.AddTeacherRequestParam;
import com.mayousheng.www.param.DeleteLabRequestParam;
import com.mayousheng.www.param.DeleteTeacherRequestParam;
import com.mayousheng.www.pojo.Laboratory;
import com.mayousheng.www.pojo.Teacher;
import com.mayousheng.www.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherMapper teacherMapper;

    //新增老师
    @RequestMapping("/addTeacher.action")
    public ModelAndView addTeacher(@RequestBody AddTeacherRequestParam addTeacherRequestParam)   {
        Teacher teacher = new Teacher();
        teacher.setIsSupervisor(addTeacherRequestParam.getIs_supervisor());
        teacher.setAbout(addTeacherRequestParam.getAbout());
        teacher.setSex(addTeacherRequestParam.getSex());
        teacher.setTelephone(addTeacherRequestParam.getTelephone());
        teacher.setMail(addTeacherRequestParam.getMail());
        teacher.setName(addTeacherRequestParam.getName());
        teacher.setLabId(addTeacherRequestParam.getLab_id());
        teacher.setDeadline(addTeacherRequestParam.getDeadline());
        teacher.setUsername(addTeacherRequestParam.getUsername());
        teacher.setPassword(addTeacherRequestParam.getPassword());
        int rows = teacherMapper.insertSelective(teacher);
        if(rows==1){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("message", "新增老师成功");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("code", ConstVar._ERROR_COMMON_);
            map.put("message", "未知错误，新增老师失败");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
        //如果老师的username重复，会直接抛出异常，已经用切片处理了该异常
    }

    //删除老师
    @RequestMapping("/deleteLab.action")
    public ModelAndView deleteLab(@RequestBody DeleteTeacherRequestParam deleteTeacherRequestParam)   {

        int rows = teacherMapper.deleteByPrimaryKey(deleteTeacherRequestParam.getId());
        Map<String,Object> map = new HashMap<String,Object>();
        if(rows==1){
            map.put("message", "删除老师成功");
        }else if(rows==0) {
            map.put("code", ConstVar._ERROR_NOTFOUND);
            map.put("message", "不存在该老师");
        }else {
            map.put("code", ConstVar._ERROR_COMMON_);
            map.put("message", "未知错误，删除老师失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }
}
