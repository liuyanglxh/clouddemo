package com.example.business.controller;

import com.example.business.pojo.Result;
import com.example.business.rpc.UserService;
import com.example.business.service.BusinessService;
import com.example.business.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;

@RestController
@RequestMapping("api/business/v1/")
public class BusinessController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private BusinessService businessService;

    @GetMapping("business/info")
    public Result getBusinessInfo(@RequestParam("userId") Integer userId) {
        Map<String, Object> userInfo = userService.getUserInfo(userId);
        return Result.success(userInfo);
    }

    @GetMapping("testLog")
    public Result testLog(@RequestParam("log") boolean log) {
        businessService.testLog(log);
        return Result.success();
    }


}
