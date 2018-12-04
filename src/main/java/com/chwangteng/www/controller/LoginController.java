package com.chwangteng.www.controller;

import com.chwangteng.www.Utils.ConstVar;
import com.chwangteng.www.param.LoginRequestParam;
import com.chwangteng.www.pojo.Admin;
import com.chwangteng.www.pojo.Teacher;
import com.chwangteng.www.service.LoginService;
import com.chwangteng.www.param.LogoutRequestParam;
import com.chwangteng.www.pojo.Student;
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

    //登录，目前使用的是session，还没有使用token
    @RequestMapping("/login.action")
    public ModelAndView login(@RequestBody LoginRequestParam loginRequestParam, HttpSession session, SessionStatus sessionStatus)   {

        //管理员
        if(loginRequestParam.getType()==ConstVar._ADMIN_){
            List<Admin> admins = loginService.getUser(loginRequestParam);
            if(admins.size()==1){
                Admin admin=admins.get(0);
                ModelAndView mv = new ModelAndView();
                mv.addObject("name",admin.getName());
                session.setAttribute(ConstVar._SESSION_USER_ID_,admin.getId());
                session.setAttribute(ConstVar._SESSION_USER_TYPE_,ConstVar._ADMIN_);
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
                session.setAttribute(ConstVar._SESSION_USER_ID_,teacher.getId());
                session.setAttribute(ConstVar._SESSION_USER_TYPE_,ConstVar._TEACHER_);
                mv.setView(new MappingJackson2JsonView());
                return mv;
            }
        }
        //学生
        if(loginRequestParam.getType()==ConstVar._STUDENT_){
            List<Student> students = loginService.getUser(loginRequestParam);
            if(students.size()==1){
                Student student = students.get(0);
                ModelAndView mv = new ModelAndView();
                mv.addObject("name",student.getName());
                session.setAttribute(ConstVar._SESSION_USER_ID_,student.getId());
                session.setAttribute(ConstVar._SESSION_USER_TYPE_,ConstVar._STUDENT_);
                mv.setView(new MappingJackson2JsonView());
                return mv;
            }
        }

        //如果还没有return
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
        map.put(ConstVar._KEY_MESSAGE_, "账号或密码错误");
        //清空session中的记录值
        session.removeAttribute(ConstVar._SESSION_USER_ID_);
        session.removeAttribute(ConstVar._SESSION_USER_TYPE_);
        sessionStatus.setComplete();
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    //注销登录，目前使用的是session，还没有使用token
    @RequestMapping("/logout.action")
    public ModelAndView logout(@RequestBody LogoutRequestParam logoutRequestParam, HttpSession session, SessionStatus sessionStatus)   {

        //清空session中的记录值
        session.removeAttribute(ConstVar._SESSION_USER_ID_);
        session.removeAttribute(ConstVar._SESSION_USER_TYPE_);
        sessionStatus.setComplete();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put(ConstVar._KEY_MESSAGE_, "注销成功");
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

}
