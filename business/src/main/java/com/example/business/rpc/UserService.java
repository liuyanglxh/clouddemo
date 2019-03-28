package com.example.business.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "user-center", path = "api/user/v1")
public interface UserService {

    @RequestMapping(path = "info", method = RequestMethod.GET)
    Map<String, Object> getUserInfo(@RequestParam("userId") Integer userId);
}
