package com.mayousheng.www.service;

import com.mayousheng.www.pojo.Teacher;

public interface TeacherService {
    //重置老师密码
    public int resetPassword(String username);
    //修改老师密码
    public int updatePassword(String username, String password);
}
