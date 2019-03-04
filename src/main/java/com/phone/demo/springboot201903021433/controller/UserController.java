/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   admin
 * Date:     2019/3/2 15:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.phone.demo.springboot201903021433.controller;

import com.phone.demo.springboot201903021433.domain.User;
import com.phone.demo.springboot201903021433.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/2
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAllUser")
    public List<User> findAllUser() {
        System.out.println("findAllUser....");
        return userService.findAllUser();
    }

    @RequestMapping("/findUserByName/{name}")
    public List<User> findUserByName(@PathVariable("name") String name) {
        System.out.println("findUserByName....");
        return userService.findUserByName(name);
    }
}