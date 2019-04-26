package com.szxfd.springboot.web.service;

import com.szxfd.springboot.web.entity.SysUser;

import java.util.List;

/**
 * @Author: xuyonghua
 * @Date: 2019/4/24 15:47
 * @Description:
 */
public interface ISysUserService {
    /**
     * 注册
     *
     * @param user
     * @return
     */
    int register(SysUser user);

    /**
     * 登录
     *
     * @param user
     * @return
     */
    SysUser login(SysUser user);

    /**
     * 获取用户列表
     *
     * @return
     */
    List<SysUser> getUserList();
}
