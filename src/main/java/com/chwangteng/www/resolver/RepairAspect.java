package com.chwangteng.www.resolver;

import com.chwangteng.www.exception.UsernameDuplicateException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RepairAspect
{
    @AfterThrowing(throwing="ex"
            , pointcut="execution(* com.chwangteng.www.controller.TeacherController.addTeacher(..))")
    public void doRecoveryActionsTeacher(Throwable ex)
    {
        System.out.println("目标方法中抛出的异常:" + ex);
        if(ex instanceof org.springframework.dao.DuplicateKeyException)
            throw new UsernameDuplicateException("");
        if(ex instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException)
            throw new UsernameDuplicateException("");
        return;
    }

    @AfterThrowing(throwing="ex"
            , pointcut="execution(* com.chwangteng.www.controller.StudentController.addStudent(..))")
    public void doRecoveryActionsStudent(Throwable ex)
    {
        System.out.println("目标方法中抛出的异常:" + ex);
        if(ex instanceof org.springframework.dao.DuplicateKeyException)
            throw new UsernameDuplicateException("");
        if(ex instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException)
            throw new UsernameDuplicateException("");
        return;
    }
}

