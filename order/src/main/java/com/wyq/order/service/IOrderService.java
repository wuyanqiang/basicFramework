package com.wyq.order.service;

import com.wyq.api.pojo.order.PO.Order;
import com.wyq.common.servlet.BaseService;

/**
 * @author: wyq
 * @Date: 2021/2/1 15:37
 * @Description:
 */
public interface IOrderService  extends BaseService<Order> {

    Order orderDetail(Long orderId);
}
