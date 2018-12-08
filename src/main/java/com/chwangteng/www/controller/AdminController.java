package com.chwangteng.www.controller;

import com.chwangteng.www.Utils.ConstVar;
import com.chwangteng.www.param.AdminUpdatePasswordRequestParam;
import com.chwangteng.www.param.ResetPasswordRequestParam;
import com.chwangteng.www.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //管理员重置学生和老师的密码
    @RequestMapping("/resetPassword.action")
    public ModelAndView resetPassword(@RequestBody ResetPasswordRequestParam resetPasswordRequestParam)   {
        int rows = adminService.resetPassword(resetPasswordRequestParam.getUsername(),
                resetPasswordRequestParam.getType());
        if(rows==1){
            Map<String,Object> map = new HashMap<String,Object>();
            if(resetPasswordRequestParam.getType()==ConstVar._TEACHER_)
                map.put(ConstVar._KEY_MESSAGE_, "密码已重置为工号后6位");
            if(resetPasswordRequestParam.getType()==ConstVar._STUDENT_)
                map.put(ConstVar._KEY_MESSAGE_, "密码已重置为学号后6位");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }else if(rows==ConstVar._ERROR_NOTFOUND){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
            if(resetPasswordRequestParam.getType()==ConstVar._TEACHER_)
                map.put(ConstVar._KEY_MESSAGE_, "不存在该老师");
            if(resetPasswordRequestParam.getType()==ConstVar._STUDENT_)
                map.put(ConstVar._KEY_MESSAGE_, "不存在该学生");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "未知错误，重置失败");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

    //管理员修改学生和老师的密码
    @RequestMapping("/updatePassword.action")
    public ModelAndView updatePassword(@RequestBody AdminUpdatePasswordRequestParam adminUpdatePasswordRequestParam)   {
        int rows = adminService.updatePassword(adminUpdatePasswordRequestParam.getUsername(),
                adminUpdatePasswordRequestParam.getType(),
                adminUpdatePasswordRequestParam.getPassword());
        if(rows==1){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_MESSAGE_, "密码已修改");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }else if(rows==ConstVar._ERROR_NOTFOUND){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
            if(adminUpdatePasswordRequestParam.getType()==ConstVar._TEACHER_)
                map.put(ConstVar._KEY_MESSAGE_, "不存在该老师");
            if(adminUpdatePasswordRequestParam.getType()==ConstVar._STUDENT_)
                map.put(ConstVar._KEY_MESSAGE_, "不存在该学生");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "未知错误，修改失败");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }
}
