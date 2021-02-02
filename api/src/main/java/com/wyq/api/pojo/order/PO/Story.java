package com.wyq.api.pojo.order.PO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.wyq.api.pojo.user.PO.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wyq
 * @Date: 2021/2/2 9:45
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Story {

    private Long id;

    private Long relevanceUserId;

    @TableField(exist=false)
    private User user;

    private String region;

    private String title;

    private String description;
}
