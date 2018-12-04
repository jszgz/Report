package com.chwangteng.www.service;

public interface StudentService {
    //重置学生密码
    public int resetPassword(String username);
    //修改学生密码
    public int updatePassword(String username, String password);
    //学生修改自己的密码
    public int updateMyPassword(int id, String password);
}
