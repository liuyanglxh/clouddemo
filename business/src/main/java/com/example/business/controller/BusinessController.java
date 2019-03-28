package com.example.business.controller;

import com.example.business.pojo.Result;
import com.example.business.rpc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/business/v1/")
public class BusinessController extends BaseController{

    @Autowired
    private UserService userService;

    @GetMapping("business/info")
    public Result getBusinessInfo(@RequestParam("userId") Integer userId) {
        Map<String, Object> userInfo = userService.getUserInfo(userId);
        return Result.success(userInfo);
    }
}
