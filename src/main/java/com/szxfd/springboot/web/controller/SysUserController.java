package com.szxfd.springboot.web.controller;

import com.szxfd.springboot.web.entity.Result;
import com.szxfd.springboot.web.entity.SysUser;
import com.szxfd.springboot.web.service.ISysUserService;
import com.szxfd.springboot.web.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody(required = false) SysUser sysUser) {
        SysUser user = sysUserService.login(sysUser);
        return ResultUtil.success(user, "登录成功");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody SysUser sysUser) {
        int index = sysUserService.register(sysUser);
        System.out.println("index...." + index);
        return ResultUtil.success(sysUser, "注册成功");
    }
}
