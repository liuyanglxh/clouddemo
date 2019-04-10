package com.example.business.service.impl;

import com.example.business.service.BusinessService;
import com.example.common.aop.annotation.LoggerAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class BusinessServiceImpl implements BusinessService {

//    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HttpServletRequest request;

    @Override
    public void test() {
        new Thread(() -> {
            if (request == null) {
                System.out.println("request is null");
            } else {
                this.printRequestHeader(request);
            }
        }).start();
        this.printRequestHeader(request);
    }

    @Override
    @LoggerAnnotation
    public void testLog(boolean log) {
        if (log) {
            throw new RuntimeException("hahaha");
        }
    }

    private void printRequestHeader(HttpServletRequest request) {
        System.out.println(String.format("header is : %s", request.getHeader("test")));
    }


}
