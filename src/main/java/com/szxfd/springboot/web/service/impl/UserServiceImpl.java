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
import com.szxfd.springboot.web.entity.BaseResponse;
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

//    @Override
//    public User queryUserById(UserCustom userCustom) {
//        Base
//        return userMapper.queryUserById(id);
//    }
//
//    @Override
//    public List<User> queryUserByName(UserCustom userCustom) {
//        return userMapper.queryUserByName(name);
//    }

    @Override
    public boolean updateUser(User user) throws Exception {
        Integer integer = userMapper.updateUser(user);
        return integer > 0;
    }

    @Override
    public BaseResponse<UserCustom> queryUserAndLotteryes(UserCustom userCustom) {
        BaseResponse<UserCustom> response = new BaseResponse<>();
        if (null == userCustom) {
            response.setSuccess(false);
            response.setErrorMsg("userCustom is null");
            return response;
        }
        UserCustom userCustomQuery = userMapper.queryUserAndLotteryes(userCustom.getId());
        if (null == userCustomQuery) {
            response.setSuccess(false);
            response.setErrorMsg("data note found in database");
        } else {
            response.setSuccess(true);
            response.setObj(userCustomQuery);
        }
        return response;
    }

    @Override
    public BaseResponse<Integer> registerUser(UserCustom userCustom) {
        BaseResponse<Integer> response = new BaseResponse<>();
        if (null == userCustom) {
            response.setSuccess(false);
            response.setErrorMsg("data note found in database");
            return response;
        }
        int result = userMapper.insertUser(userCustom);
        if (result > 0) {
            response.setSuccess(true);
            response.setObj(userCustom.getId());
        } else {
            response.setSuccess(false);
            response.setErrorMsg("register fail");
        }
        return response;
    }
}