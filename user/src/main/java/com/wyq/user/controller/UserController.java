package com.wyq.user.controller;

import com.wyq.api.pojo.user.PO.User;
import com.wyq.common.control.Result;
import com.wyq.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wyq
 * @Date: 2021/2/1 11:33
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/user/info/{userId}")
    public Result userInfo(@PathVariable long userId){
        User user = userService.getById(userId);
        return Result.ok(user);
    }
}
