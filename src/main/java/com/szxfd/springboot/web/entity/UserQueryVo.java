/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserQueryVo
 * Author:   admin
 * Date:     2019/3/7 23:41
 * Description: 用户查询包装类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户查询包装类〉
 *
 * @author admin
 * @create 2019/3/7
 * @since 1.0.0
 */
public class UserQueryVo {

    private List<Integer> ids;

    //用户信息
    private UserCustom userCustom;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}