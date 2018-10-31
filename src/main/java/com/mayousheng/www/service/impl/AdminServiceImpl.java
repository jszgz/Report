package com.mayousheng.www.service.impl;

import com.mayousheng.www.Utils.ConstVar;
import com.mayousheng.www.mapper.AdminMapper;
import com.mayousheng.www.service.AdminService;
import com.mayousheng.www.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private TeacherService teacherService;

    //重置密码
    public int resetPassword(String username, int type){
        if(type==ConstVar._TEACHER_){
            return teacherService.resetPassword(username);
        }
        if(type==ConstVar._STUDENT_){
            return ConstVar._ERROR_COMMON_;
        }
        return ConstVar._ERROR_COMMON_;
    }

    //修改密码
    public int updatePassword(String username, int type, String password){
        if(type==ConstVar._TEACHER_){
            return teacherService.updatePassword(username, password);
        }
        if(type==ConstVar._STUDENT_){
            return ConstVar._ERROR_COMMON_;
        }
        return ConstVar._ERROR_COMMON_;
    }
}
