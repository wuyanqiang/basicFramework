package com.wyq.order.service;

import com.wyq.api.pojo.order.PO.Story;
import com.wyq.common.servlet.BaseService;

/**
 * @author: wyq
 * @Date: 2021/2/2 9:49
 * @Description:
 */
public interface IStoryService extends BaseService<Story> {

    Story storyDetail(Long id);
}
