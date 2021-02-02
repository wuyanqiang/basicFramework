package com.wyq.api.pojo.order.PO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wyq
 * @Date: 2021/2/1 15:32
 * @Description: 订单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long orderId;

    private String orderName;

    private Long buyerId;

    private Integer status;
}
