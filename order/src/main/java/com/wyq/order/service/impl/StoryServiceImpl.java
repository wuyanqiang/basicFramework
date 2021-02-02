package com.wyq.order.service.impl;

import com.wyq.api.pojo.order.PO.Story;
import com.wyq.api.pojo.user.PO.User;
import com.wyq.common.system.Result;
import com.wyq.common.servlet.BaseServiceImpl;
import com.wyq.order.mapper.IStoryMapper;
import com.wyq.order.service.FUserService;
import com.wyq.order.service.IStoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wyq
 * @Date: 2021/2/2 9:50
 * @Description:
 */
@Service
@Slf4j
public class StoryServiceImpl extends BaseServiceImpl<IStoryMapper, Story> implements IStoryService {

    @Autowired
    private IStoryMapper storyMapper;
    @Autowired
    private FUserService userService;

    @Override
    public Story storyDetail(Long id) {
        Story story = storyMapper.selectById(id);
        if(story != null){
            Long relevanceUserId = story.getRelevanceUserId();
            Result<User> result = userService.getUserDetail(relevanceUserId);
            story.setUser(result.getData());
        }
        return story;
    }
}
