package com.mayousheng.www.service;

import com.mayousheng.www.param.LoginRequestParam;

import java.util.List;

public interface LoginService {

    public List getUser(LoginRequestParam param);
}
