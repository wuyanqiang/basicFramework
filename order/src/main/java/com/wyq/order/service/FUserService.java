package com.wyq.order.service;

import com.wyq.api.pojo.user.PO.User;
import com.wyq.common.control.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: wyq
 * @Date: 2021/2/2 9:53
 * @Description:
 */
@FeignClient("user")
public interface FUserService {


    @GetMapping("/user/info/{userId}")
    Result<User> getUserDetail(@PathVariable("userId") Long userId);
}
