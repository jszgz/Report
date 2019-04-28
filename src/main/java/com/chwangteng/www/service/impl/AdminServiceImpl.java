package com.chwangteng.www.service.impl;

import com.chwangteng.www.Utils.ConstVar;
import com.chwangteng.www.mapper.AdminMapper;
import com.chwangteng.www.pattern.strategy.Environment;
import com.chwangteng.www.pattern.strategy.StrategyFactory;
import com.chwangteng.www.pattern.strategy.StudentStrategy;
import com.chwangteng.www.pattern.strategy.TeacherStrategy;
import com.chwangteng.www.service.AdminService;
import com.chwangteng.www.service.TeacherService;
import com.chwangteng.www.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private Environment environment;
    @Autowired
    private StudentStrategy studentStrategy;
    @Autowired
    private TeacherStrategy teacherStrategy;

    @Autowired
    @Qualifier("strategyFactoryConcrete")
    private StrategyFactory strategyFactory;
    //重置密码
    public int resetPassword(String username, int type){

        environment.setStrategy(strategyFactory.getStratery(type));
        return environment.resetPassword(username);

/*        if(type==ConstVar._TEACHER_){
            environment.setStrategy(teacherStrategy);
            return environment.resetPassword(username);
            //return teacherService.resetPassword(username);
        }
        if(type==ConstVar._STUDENT_){
            environment.setStrategy(studentStrategy);
            return environment.resetPassword(username);
            //return studentService.resetPassword(username);
        }
        return ConstVar._ERROR_COMMON_;*/
    }

    //修改密码
    public int updatePassword(String username, int type, String password){
        if(type==ConstVar._TEACHER_){
            return teacherService.updatePassword(username, password);
        }
        if(type==ConstVar._STUDENT_){
            return studentService.updatePassword(username, password);
        }
        return ConstVar._ERROR_COMMON_;
    }
}
