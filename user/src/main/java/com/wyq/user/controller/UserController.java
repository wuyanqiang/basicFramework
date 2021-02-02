package com.wyq.user.controller;

import com.wyq.api.pojo.user.PO.User;
import com.wyq.common.system.MappingPrefix;
import com.wyq.common.system.Result;
import com.wyq.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wyq
 * @Date: 2021/2/1 11:33
 * @Description:
 */
@RestController
@RequestMapping(MappingPrefix.userServicePreFix)
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/info/{userId}")
    public Result userInfo(@PathVariable long userId){

        User user = userService.getById(userId);
        return Result.ok(user);
    }

    @PostMapping("/login")
    public Result userLogin(String username, String password ){
        return userService.userLogin(username,password);
    }
}
