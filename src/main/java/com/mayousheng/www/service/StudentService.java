package com.mayousheng.www.service;

public interface StudentService {
    //重置学生密码
    public int resetPassword(String username);
    //修改学生密码
    public int updatePassword(String username, String password);
}
