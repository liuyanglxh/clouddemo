package com.example.common.aop.excutioner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;

@Aspect
@Configuration
public class LoggerAop {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.example.business.service.impl.BusinessServiceImpl.*(..))")
    public void pointcut() {
    }


    @AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
    public void doLog(JoinPoint joinPoint, Throwable throwable) throws IllegalAccessException {
        System.out.println("error........................");
        Object target = joinPoint.getTarget();
        Class<?> clz = target.getClass();
        Field[] fields = clz.getDeclaredFields();
        Field loggerField = null;
        if (fields != null) {
            for (Field field : fields) {
                Class<?> fieldClaz = field.getDeclaringClass();
                if (fieldClaz.equals(Logger.class)) {
                    loggerField = field;
                }
            }
        }
        if (loggerField != null) {
            Logger logger = (Logger) loggerField.get(target);
            logger.error("error", throwable);
        } else {
            this.logger.error("error", throwable);
        }
    }
}

