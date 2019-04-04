package com.example.business.rpc;

import com.example.business.rpc.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "user-center", path = "api/user/v1", fallbackFactory = UserServiceFallback.class)
public interface UserService {

    @GetMapping(path = "info")
    Map<String, Object> getUserInfo(@RequestParam("userId") Integer userId);
}
