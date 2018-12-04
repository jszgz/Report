package com.chwangteng.www.service;

public interface TeacherService {
    //重置老师密码
    public int resetPassword(String username);
    //修改老师密码
    public int updatePassword(String username, String password);
    //老师修改自己的密码
    public int updateMyPassword(int id, String password);
}
