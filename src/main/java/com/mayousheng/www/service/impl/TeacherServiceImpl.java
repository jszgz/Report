package com.mayousheng.www.service.impl;

import com.mayousheng.www.mapper.LaboratoryMapper;
import com.mayousheng.www.mapper.TeacherMapper;
import com.mayousheng.www.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
}
