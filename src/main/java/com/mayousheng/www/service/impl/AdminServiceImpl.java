package com.mayousheng.www.service.impl;

import com.mayousheng.www.mapper.AdminMapper;
import com.mayousheng.www.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
}
