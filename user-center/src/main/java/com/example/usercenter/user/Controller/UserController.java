package com.example.usercenter.user.Controller;

import com.example.usercenter.user.pojo.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/v1/")
public class UserController extends BaseController {

    @GetMapping("info")
    public Object getUserInfo(@RequestParam("userId") Integer userId) {

        UserVo vo = new UserVo();
        vo.setId(userId);
        vo.setName("user-" + userId);
        return vo;
    }
}
