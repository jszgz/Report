package com.mayousheng.www.controller;

import com.mayousheng.www.param.LoginRequestParam;
import com.mayousheng.www.service.AdminService;
import com.mayousheng.www.service.LoginService;
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
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //登录，目前还没有开始处理token和cookie等
    @RequestMapping("/login.action")
    public ModelAndView login(@RequestBody LoginRequestParam loginRequestParam) {

        //管理员
        if(loginRequestParam.getType()==1){

        }
        //老师
        if(loginRequestParam.getType()==2){

        }
        //学生
        if(loginRequestParam.getType()==3){

        }
        List records = loginService.getUser(loginRequestParam);

        if(records.size()==1){
            ModelAndView mv = new ModelAndView();
            mv.addObject(records.get(0));
            mv.setView(new MappingJackson2JsonView());
            return mv;
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("code", -1);
            map.put("message", "账号或密码错误");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

}
