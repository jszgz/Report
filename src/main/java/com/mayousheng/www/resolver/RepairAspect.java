package com.mayousheng.www.resolver;

import com.mayousheng.www.exception.UsernameDuplicateException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class RepairAspect
{
/*    @AfterThrowing(throwing="ex"
            , pointcut="execution(* com.mayousheng.www.controller.TeacherController.add(..))")
    public void doRecoveryActions(Throwable ex)
    {
        System.out.println("目标方法中抛出的异常:" + ex);
        if(ex instanceof org.springframework.dao.DuplicateKeyException)
            throw new UsernameDuplicateException("");
        if(ex instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException)
            throw new UsernameDuplicateException("");
        return;
    }*/
}

