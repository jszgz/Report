package com.chwangteng.www.service;

public interface AdminService {

    //重置密码
    public int resetPassword(String username, int type);

    //修改密码
    public int updatePassword(String username, int type, String password);
}
