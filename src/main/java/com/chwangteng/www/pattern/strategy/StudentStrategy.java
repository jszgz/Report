package com.chwangteng.www.pattern.strategy;

import com.chwangteng.www.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class StudentStrategy implements Strategy {

    @Autowired
    public StudentService studentService;

    @Override
    public int resetPassword(String username) {
        return studentService.resetPassword(username);
    }
}
