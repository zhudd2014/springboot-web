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

import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.RespError;
import com.szxfd.springboot.web.entity.User;
import com.szxfd.springboot.web.entity.UserQueryVo;
import com.szxfd.springboot.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/findUserById/{id}")
    public BaseResponse<User> findUserById(@PathVariable("id") int id) {
        System.out.println("queryUserById");
        BaseResponse response = new BaseResponse();
        try {
            response.setSuccess(true);
            response.setObj(userService.queryUserById(id));
        } catch (Exception e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setErrorCode(RespError.MYBATIS_ERROR.getCode());
            response.setErrorMsg(e.getMessage());
        }
        return response;
    }

    @RequestMapping("/findUserByName/{name}")
    public BaseResponse<List<User>> findUserByName(@PathVariable("name") String name) {
        System.out.println("queryUserByName....");
        BaseResponse response = new BaseResponse();
        try {
            response.setSuccess(true);
            response.setObj(userService.queryUserByName(name));
        } catch (Exception e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setErrorCode(RespError.MYBATIS_ERROR.getCode());
            response.setErrorMsg(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    public BaseResponse<List<User>> findUser(@RequestBody UserQueryVo userQueryVo) {
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
    public BaseResponse<Integer> findUserCount(@RequestBody UserQueryVo userQueryVo) {
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
}