package com.mayousheng.www.service.impl;

import com.mayousheng.www.Utils.ConstantVariable;
import com.mayousheng.www.mapper.AdminMapper;
import com.mayousheng.www.mapper.TeacherMapper;
import com.mayousheng.www.param.LoginRequestParam;
import com.mayousheng.www.pojo.AdminExample;
import com.mayousheng.www.pojo.TeacherExample;
import com.mayousheng.www.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    public List getUser(LoginRequestParam param){
        List records = null;
        //管理员
        if(param.getType()==ConstantVariable._ADMIN_){
            AdminExample adminExample = new AdminExample();
            adminExample.createCriteria().andUsernameEqualTo(param.getUsername())
                    .andPasswordEqualTo(param.getPassword());
            return adminMapper.selectByExample(adminExample);
        }
        //老师
        if(param.getType()==ConstantVariable._TEACHER_){
            TeacherExample teacherExample = new TeacherExample();
            teacherExample.createCriteria().andUsernameEqualTo(param.getUsername())
                    .andPasswordEqualTo(param.getPassword());
            return  teacherMapper.selectByExample(teacherExample);
        }
        //学生
        if(param.getType()==ConstantVariable._STUDENT_){

        }
        return records;
    }
}
