package com.chwangteng.www.service;

import com.chwangteng.www.param.LoginRequestParam;

import java.util.List;

public interface LoginService {

    //三种角色公用的登录
    public List getUser(LoginRequestParam param);

}
