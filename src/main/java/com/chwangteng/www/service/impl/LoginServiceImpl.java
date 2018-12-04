package com.chwangteng.www.service.impl;

import com.chwangteng.www.Utils.ConstVar;
import com.chwangteng.www.mapper.AdminMapper;
import com.chwangteng.www.mapper.TeacherMapper;
import com.chwangteng.www.param.LoginRequestParam;
import com.chwangteng.www.pojo.AdminExample;
import com.chwangteng.www.pojo.TeacherExample;
import com.chwangteng.www.service.LoginService;
import com.chwangteng.www.mapper.StudentMapper;
import com.chwangteng.www.pojo.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;


    public List getUser(LoginRequestParam param){
        List records = null;
        //管理员
        if(param.getType()==ConstVar._ADMIN_){
            AdminExample adminExample = new AdminExample();
            adminExample.createCriteria().andUsernameEqualTo(param.getUsername())
                    .andPasswordEqualTo(param.getPassword());
            return adminMapper.selectByExample(adminExample);
        }
        //老师
        if(param.getType()==ConstVar._TEACHER_){
            TeacherExample teacherExample = new TeacherExample();
            teacherExample.createCriteria().andUsernameEqualTo(param.getUsername())
                    .andPasswordEqualTo(param.getPassword());
            return  teacherMapper.selectByExample(teacherExample);
        }
        //学生
        if(param.getType()==ConstVar._STUDENT_){
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andUsernameEqualTo(param.getUsername())
                    .andPasswordEqualTo(param.getPassword());
            return studentMapper.selectByExample(studentExample);

        }
        return records;
    }

}
