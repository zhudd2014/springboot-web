package com.szxfd.springboot.web.service.impl;

import com.szxfd.springboot.web.dao.SysUserMapper;
import com.szxfd.springboot.web.entity.SysUser;
import com.szxfd.springboot.web.service.ISysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public int register(SysUser user) {
        return sysUserMapper.insertSelective(user);
    }

    @Override
    public SysUser login(SysUser user) {
        return sysUserMapper.findUser(user);
    }

    @Override
    public List<SysUser> getUserList() {
        return null;
    }
}
