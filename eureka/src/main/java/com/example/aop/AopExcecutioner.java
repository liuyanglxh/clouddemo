package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExcecutioner {

    @Pointcut("execution(* com.example.aop.*.*(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object cut(ProceedingJoinPoint point) throws Throwable {
        System.out.println("success cut");
        return point.proceed();
    }
}
