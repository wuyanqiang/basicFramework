package com.wyq.order.controller;

import com.wyq.common.control.Result;
import com.wyq.order.service.IOrderService;
import com.wyq.order.service.IStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wyq
 * @Date: 2021/2/1 15:46
 * @Description:
 */
@RestController("/story")
public class StoryController {

    @Autowired
    private IStoryService storyService;

    @GetMapping("/storyDetail/{id}")
    public Result storyDetail(@PathVariable Long id){
        return Result.ok(storyService.storyDetail(id));
    }
}
