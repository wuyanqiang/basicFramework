package com.wyq.order.service.impl;

import com.wyq.api.pojo.order.PO.Order;
import com.wyq.common.servlet.BaseServiceImpl;
import com.wyq.order.mapper.IOrderMapper;
import com.wyq.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wyq
 * @Date: 2021/2/1 15:35
 * @Description:
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<IOrderMapper, Order> implements IOrderService {

    @Autowired
    private IOrderMapper orderMapper;

    @Override
    public Order orderDetail(Long orderId) {
        return orderMapper.selectById(orderId);
    }
}
