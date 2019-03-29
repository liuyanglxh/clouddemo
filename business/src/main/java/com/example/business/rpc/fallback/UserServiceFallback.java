package com.example.business.rpc.fallback;

import com.example.business.rpc.UserService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserServiceFallback implements FallbackFactory<UserService> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {

            @Override
            public Map<String, Object> getUserInfo(Integer userId) {
                logger.error("error call GET user-center api/user/v1/info?userId=" + userId);
                return null;
            }
        };
    }
}
