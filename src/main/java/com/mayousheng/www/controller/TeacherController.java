package com.mayousheng.www.controller;


import com.mayousheng.www.Utils.ConstVar;
import com.mayousheng.www.mapper.LaboratoryMapper;
import com.mayousheng.www.mapper.TeacherMapper;
import com.mayousheng.www.param.*;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private LaboratoryMapper laboratoryMapper;
    @Autowired
    private TeacherService teacherService;

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
        if(rows==1) {
            //如果没有设置密码，就重置老师的密码，密码是后六位
            if (addTeacherRequestParam.getPassword()==""||addTeacherRequestParam.getPassword()==null){
                teacherService.resetPassword(teacher.getUsername());
            }
            //如果是主管老师,去更新实验室表
            if(teacher.getIsSupervisor()==ConstVar._SUPER_YES_){
                //再去更新实验室表
                Laboratory lab= laboratoryMapper.selectByPrimaryKey(addTeacherRequestParam.getLab_id());
                if(lab!=null){
                    lab.setTeacherId(teacher.getId());
                    int labrows = laboratoryMapper.updateByPrimaryKeySelective(lab);
                    if(labrows==1){
                        Map<String,Object> map = new HashMap<String,Object>();
                        map.put(ConstVar._KEY_MESSAGE_, "新增老师成功");
                        return new ModelAndView(new MappingJackson2JsonView(),map);
                    }else{
                        Map<String,Object> map = new HashMap<String,Object>();
                        map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
                        map.put(ConstVar._KEY_MESSAGE_, "更新该老师主管的实验室失败");
                        return new ModelAndView(new MappingJackson2JsonView(),map);
                    }
                }else{
                    Map<String,Object> map = new HashMap<String,Object>();
                    map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
                    map.put(ConstVar._KEY_MESSAGE_, "没有找到该老师主管的实验室");
                    return new ModelAndView(new MappingJackson2JsonView(),map);
                }
            }else{//不需要更新实验室表，直接成功
                Map<String,Object> map = new HashMap<String,Object>();
                map.put(ConstVar._KEY_MESSAGE_, "新增老师成功");
                return new ModelAndView(new MappingJackson2JsonView(),map);
            }
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "未知错误，新增老师失败");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
        //如果老师的username重复，会直接抛出异常，已经用切片处理了该异常
    }

    //删除老师
    @RequestMapping("/deleteTeacher.action")
    public ModelAndView deleteTeacher(@RequestBody DeleteTeacherRequestParam deleteTeacherRequestParam)   {

        int rows = teacherMapper.deleteByPrimaryKey(deleteTeacherRequestParam.getId());
        Map<String,Object> map = new HashMap<String,Object>();
        if(rows==1){
            map.put(ConstVar._KEY_MESSAGE_, "删除老师成功");
        }else if(rows==0) {
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
            map.put(ConstVar._KEY_MESSAGE_, "不存在该老师");
        }else {
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "未知错误，删除老师失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    //更新老师信息//还需要更新实验室表中的内容！！！！！！！！！！
    @RequestMapping("/updateTeacher.action")
    public ModelAndView updateTeacher(@RequestBody UpdateTeacherRequestParam updateTeacherRequestParam){

        Teacher teacher = new Teacher();
        teacher.setIsSupervisor(updateTeacherRequestParam.getIs_supervisor());
        teacher.setAbout(updateTeacherRequestParam.getAbout());
        teacher.setSex(updateTeacherRequestParam.getSex());
        teacher.setTelephone(updateTeacherRequestParam.getTelephone());
        teacher.setMail(updateTeacherRequestParam.getMail());
        teacher.setName(updateTeacherRequestParam.getName());
        teacher.setLabId(updateTeacherRequestParam.getLab_id());//还需要更新实验室表中的内容！！！！！！！！！！
        teacher.setDeadline(updateTeacherRequestParam.getDeadline());
        teacher.setUsername(updateTeacherRequestParam.getUsername());
        teacher.setPassword(updateTeacherRequestParam.getPassword());
        int rows = teacherMapper.updateByPrimaryKeySelective(teacher);
        Map<String,Object> map = new HashMap<String,Object>();
        if(rows==1){
            map.put(ConstVar._KEY_MESSAGE_, "更新成功");
        }else if(rows==0) {
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
            map.put(ConstVar._KEY_MESSAGE_, "不存在该老师");
        }else {
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "未知错误，更新老师失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }


    //






    //查找老师信息
}
