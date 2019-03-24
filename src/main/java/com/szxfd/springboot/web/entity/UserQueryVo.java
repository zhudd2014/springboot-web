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

    /**
     * 基本数据类型绑定
     */
    private String uuid;

    /**
     * List类型绑定
     */
    private List<Integer> ids;
    /**
     * 数组类型绑定
     */
    private String uuids[];
    /**
     * List类型绑定
     */
    private List<UserCustom> userCustoms;

    /**
     * 包装pojo类型绑定
     */
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String[] getUuids() {
        return uuids;
    }

    public void setUuids(String[] uuids) {
        this.uuids = uuids;
    }

    public List<UserCustom> getUserCustoms() {
        return userCustoms;
    }

    public void setUserCustoms(List<UserCustom> userCustoms) {
        this.userCustoms = userCustoms;
    }
}