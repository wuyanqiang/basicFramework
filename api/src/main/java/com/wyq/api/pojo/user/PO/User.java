package com.wyq.api.pojo.user.PO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: wyq
 * @Date: 2021/2/1 11:08
 * @Description:
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String nickName;

    private String mobile;

    private String password;
}
