package com.chwangteng.www.pattern.strategy;

import com.chwangteng.www.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TeacherStrategy implements Strategy{

    @Autowired
    private TeacherService teacherService;

    @Override
    public int resetPassword(String username) {
        return teacherService.resetPassword(username);
    }
}
