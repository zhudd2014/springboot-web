/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   admin
 * Date:     2019/3/2 15:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.service.impl;

import com.szxfd.springboot.web.dao.UserMapper;
import com.szxfd.springboot.web.entity.User;
import com.szxfd.springboot.web.entity.UserCustom;
import com.szxfd.springboot.web.entity.UserQueryVo;
import com.szxfd.springboot.web.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/2
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserCustom> queryUserList(UserQueryVo userQueryVo) {
        return userMapper.queryUserList(userQueryVo);
    }

    @Override
    public int queryUserCount(UserQueryVo userQueryVo) {
        return userMapper.queryUserCount(userQueryVo);
    }

    @Override
    public User queryUserById(int id) throws Exception {
        return userMapper.queryUserById(id);
    }

    @Override
    public List<User> queryUserByName(String name) throws Exception {
        return userMapper.queryUserByName(name);
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        Integer integer = userMapper.updateUser(user);
        return integer > 0;
    }
}