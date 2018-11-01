package com.mayousheng.www.controller;

import com.mayousheng.www.Utils.ConstVar;
import com.mayousheng.www.param.LoginRequestParam;
import com.mayousheng.www.param.LogoutRequestParam;
import com.mayousheng.www.param.ResetPasswordRequestParam;
import com.mayousheng.www.pojo.Admin;
import com.mayousheng.www.pojo.Teacher;
import com.mayousheng.www.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
//@SessionAttributes(value = {"tableId","tabletype"}) 不好用,会自动返回无法控制，还是手动读写方便
public class LoginController {

    @Autowired
    private LoginService loginService;

    //登录，目前还没有开始处理token和cookie等
    @RequestMapping("/login.action")
    public ModelAndView login(@RequestBody LoginRequestParam loginRequestParam, HttpSession session, SessionStatus sessionStatus)   {

        //管理员
        if(loginRequestParam.getType()==ConstVar._ADMIN_){
            List<Admin> admins = loginService.getUser(loginRequestParam);
            if(admins.size()==1){
                Admin admin=admins.get(0);
                ModelAndView mv = new ModelAndView();
                mv.addObject("name",admin.getName());
                session.setAttribute("tableId",admin.getId());
                session.setAttribute("tabletype",ConstVar._ADMIN_);
                mv.setView(new MappingJackson2JsonView());
                return mv;
            }
        }
        //老师
        if(loginRequestParam.getType()==ConstVar._TEACHER_){
            List<Teacher> teachers = loginService.getUser(loginRequestParam);
            if(teachers.size()==1){
                Teacher teacher = teachers.get(0);
                ModelAndView mv = new ModelAndView();
                mv.addObject("name",teacher.getName());
                session.setAttribute("tableId",teacher.getId());
                session.setAttribute("tabletype",ConstVar._TEACHER_);
                mv.setView(new MappingJackson2JsonView());
                return mv;
            }
        }
        //学生
        if(loginRequestParam.getType()==ConstVar._STUDENT_){

        }

        //如果还没有return
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
        map.put(ConstVar._KEY_MESSAGE_, "账号或密码错误");
        //清空session中的记录值
        session.removeAttribute("tableId");
        session.removeAttribute("tabletype");
        sessionStatus.setComplete();
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    //注销登录，目前还没有开始处理token和cookie等
    @RequestMapping("/logout.action")
    public ModelAndView logout(@RequestBody LogoutRequestParam logoutRequestParam, HttpSession session, SessionStatus sessionStatus)   {

        //清空session中的记录值
        session.removeAttribute("tableId");
        session.removeAttribute("tabletype");
        sessionStatus.setComplete();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put(ConstVar._KEY_MESSAGE_, "注销成功");
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

}
