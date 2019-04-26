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
import com.szxfd.springboot.web.rsa.RSAUtils;
import com.szxfd.springboot.web.service.IUserService;
import com.szxfd.springboot.web.utils.FastJsonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    static String publicKey;
    static String privateKey;

    static {
        try {
            Map<String, Object> keyMap = RSAUtils.genKeyPair();
            publicKey = RSAUtils.getPublicKey(keyMap);
            privateKey = RSAUtils.getPrivateKey(keyMap);
//            System.err.println("公钥: \n\r" + publicKey);
//            System.err.println("私钥： \n\r" + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BaseResponse<String> getPublicKey() {
        return new BaseResponse<>(true, publicKey);
    }

    @Override
    public BaseResponse<UserCustom> register(String userInfo) {
        return null;
    }

    @Override
    public BaseResponse<Boolean> login(byte[] userInfo) {
        if (null == userInfo || "".equals(userInfo)) {
            return new BaseResponse<>("", "userInfo is null");
        }
        byte[] decodedData;
        try {
            decodedData = RSAUtils.decryptByPrivateKey(userInfo, privateKey);
            String target = new String(decodedData);
            UserCustom userCustom = FastJsonUtils.getJsonToBean(target, UserCustom.class);
            if (null == userCustom) {
                return new BaseResponse<>("", "userCusom is null");
            }
            String username = userCustom.getUsername();
            String password = userCustom.getPassword();
            if (null == username || "".equals(username)) {
                return new BaseResponse<>("", "username is empty");
            }
            if (null == password || "".equals(password)) {
                return new BaseResponse<>("", "password is empty");
            }
            int count = userMapper.queryUserByUsernameAndPassword(userCustom);
            if (count == 0) {
                return new BaseResponse<>("", "username or password is wrong");
            }
            if (count > 1) {
                return new BaseResponse<>("", "exist more than one account");
            }
            //登录成功
            return new BaseResponse<>(true, true);
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse<>("", e.getMessage());
        }
    }

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
        String username = userCustom.getUsername();
        String password = userCustom.getPassword();
        if (null == username || "".equals(username)) {
            return new BaseResponse<>("", "username is empty");
        }
        if (null == password || "".equals(password)) {
            return new BaseResponse<>("", "password is empty");
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