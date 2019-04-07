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
package com.szxfd.springboot.web.controller;

import com.szxfd.springboot.web.entity.*;
import com.szxfd.springboot.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/hello")
    public String hello() {
        return "hello phone";
    }

//    @RequestMapping("/findUserById/{id}")
//    public BaseResponse<User> findUserById(@RequestBody UserCustom userCustom) {
////        System.out.println("queryUserById");
////        BaseResponse response = new BaseResponse();
////        try {
////            response.setSuccess(true);
////            response.setObj(userService.queryUserById(id));
////        } catch (Exception e) {
////            e.printStackTrace();
////            response.setSuccess(false);
////            response.setErrorCode(RespError.MYBATIS_ERROR.getCode());
////            response.setErrorMsg(e.getMessage());
////        }
////        return response;
//        return userService.queryUserById(userCustom);
//    }
//
//    @RequestMapping("/findUserByName/{name}")
//    public BaseResponse<List<User>> findUserByName(@RequestBody UserCustom userCustom) {
//        System.out.println("queryUserByName....");
////        BaseResponse response = new BaseResponse();
////        try {
////            response.setSuccess(true);
////            response.setObj(userService.queryUserByName(name));
////        } catch (Exception e) {
////            e.printStackTrace();
////            response.setSuccess(false);
////            response.setErrorCode(RespError.MYBATIS_ERROR.getCode());
////            response.setErrorMsg(e.getMessage());
////        }
////        return response;
//        return userService.queryUserByName(userCustom);
//    }

    @RequestMapping(value = "/findUserList", method = RequestMethod.POST)
    public BaseResponse<List<User>> findUserList(@RequestBody(required = false) UserQueryVo userQueryVo) {
        System.out.println("findUser....");
        BaseResponse response = new BaseResponse();
        try {
            response.setSuccess(true);
            response.setObj(userService.queryUserList(userQueryVo));
        } catch (Exception e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setErrorCode(RespError.MYBATIS_ERROR.getCode());
            response.setErrorMsg(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/findUserCount", method = RequestMethod.POST)
    public BaseResponse<Integer> findUserCount(@RequestBody(required = false) UserQueryVo userQueryVo) {
        System.out.println("findUserCount....");
        BaseResponse response = new BaseResponse();
        try {
            response.setSuccess(true);
            response.setObj(userService.queryUserCount(userQueryVo));
        } catch (Exception e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setErrorCode(RespError.MYBATIS_ERROR.getCode());
            response.setErrorMsg(e.getMessage());
        }
        return response;
    }

//    @RequestMapping("/insertUser")
//    public BaseResponse insertUser(@RequestBody User user) {
//        System.out.println("insertUser....");
//        BaseResponse response = new BaseResponse();
//        try {
//            response.setSuccess(userService.insertUser(user));
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.setSuccess(false);
//            response.setError(RespError.MYBATIS_ERROR);
//        }
//        return response;
//    }
//
//    @RequestMapping("/deleteUser/{id}")
//    public BaseResponse deleteUser(@PathVariable("id") int id) {
//        System.out.println("deleteUser....");
//        BaseResponse response = new BaseResponse();
//        try {
//            response.setSuccess(userService.deleteUser(id));
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.setSuccess(false);
//            response.setError(RespError.MYBATIS_ERROR);
//        }
//        return response;
//    }

    @RequestMapping("/updateUser")
    public BaseResponse updateUser(@RequestBody User user) {
        System.out.println("updateUser....");
        BaseResponse response = new BaseResponse();
        try {
            response.setSuccess(userService.updateUser(user));
        } catch (Exception e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setErrorCode(RespError.MYBATIS_ERROR.getCode());
            response.setErrorMsg(e.getMessage());
        }
        return response;
    }

//    @RequestMapping("/updateUserPojo")
//    public BaseResponse<User> updateUserPojo(@RequestBody User user) {
//        BaseResponse<User> response = new BaseResponse<>();
//        response.setObj(user);
//        return response;
//    }
//
//    @RequestMapping("/updateUserQueryVoPojo")
//    public BaseResponse<UserQueryVo> updateUserQueryVoPojo(@RequestBody UserQueryVo userQueryVo) {
//        BaseResponse<UserQueryVo> response = new BaseResponse<>();
//        response.setObj(userQueryVo);
//        return response;
//    }
//
//    @RequestMapping("/updateUsers")
//    public BaseResponse<List<User>> updateUsers(@RequestBody List<User> users) {
//        BaseResponse<List<User>> response = new BaseResponse<>();
//        response.setObj(users);
//        return response;
//    }

    @RequestMapping("/getPublicKey")
    public BaseResponse<String> getPublicKey() {
        return userService.getPublicKey();
    }

    @RequestMapping("/register")
    public BaseResponse<Integer> register(@RequestBody UserCustom userCustom) {
        return userService.registerUser(userCustom);
    }

    @RequestMapping(value = "/login")
    public BaseResponse<Boolean> login(@RequestBody byte[] userInfo) {
        return userService.login(userInfo);
    }

    @RequestMapping("/queryUserAndLotteryesByUserId")
    public BaseResponse<UserCustom> queryUserAndLotteryesByUserId(@RequestBody UserCustom userCustom) {
        return userService.queryUserAndLotteryes(userCustom);
    }
}