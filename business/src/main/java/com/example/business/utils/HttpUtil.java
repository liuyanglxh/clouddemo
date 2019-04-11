package com.example.business.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {


    public static HttpServletRequest getCurrentRequest() {
        try {
            ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            return ra.getRequest();
        } catch (IllegalStateException e) {
            return null;
        }
    }

    public static HttpServletResponse getCurrentResponse() {
        try {
            ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            return ra.getResponse();
        } catch (IllegalStateException e) {
            return null;
        }
    }

}
