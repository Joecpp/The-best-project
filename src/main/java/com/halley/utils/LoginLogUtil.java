package com.halley.utils;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.halley.bean.Admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * @author Jan
 * @Date 2020/7/19 10:58
 */
@Aspect
@Component
public class LoginLogUtil {



    private final static Logger logger = Logger.getLogger("aopLogger");

    @Pointcut(value = "execution(* com.halley.controller.LoginController.Login(..))")
    public void myCut(){}

    @Around(value = "myCut()")
    public Object LoginLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Map result = null;
        try {
            Admin admin = (Admin) args[0];
            logger.info("用户名："+admin.getUsername()+"  密码为："+admin.getPassword()+"  请求登录");
            result = (Map) joinPoint.proceed(args);
        } catch (Exception e) {
            logger.error(e);

        } finally {
            logger.info("登录状态："+result.get("msg"));
        }
        return result;
    }

}
