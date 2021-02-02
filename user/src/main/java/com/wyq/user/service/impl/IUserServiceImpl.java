package com.wyq.user.service.impl;

import com.wyq.api.pojo.user.PO.User;
import com.wyq.common.servlet.BaseServiceImpl;
import com.wyq.user.mapper.IUserMapper;
import com.wyq.user.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author: wyq
 * @Date: 2021/2/1 11:28
 * @Description:
 */
@Service
public class IUserServiceImpl extends BaseServiceImpl<IUserMapper, User> implements IUserService {
}
