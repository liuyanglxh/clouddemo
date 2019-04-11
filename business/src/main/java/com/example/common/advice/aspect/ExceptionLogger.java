package com.example.common.advice.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 方法执行出错后，打印日志
 */
@Aspect
@Configuration
public class ExceptionLogger {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.example.common.advice.annotation.LogException)")
    public void pointcut() {
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
    public void doLog(Throwable throwable) {
        logger.error("", throwable);
    }
}

