package com.mayousheng.www.service;

import com.mayousheng.www.param.LoginRequestParam;

import java.util.List;

public interface LoginService {

    //三种角色公用的登录
    public List getUser(LoginRequestParam param);

}
