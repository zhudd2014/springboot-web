package com.szxfd.springboot.web.dao;

import com.szxfd.springboot.web.entity.SysUser;

public interface SysUserMapper {
    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser findUser(SysUser user);
}