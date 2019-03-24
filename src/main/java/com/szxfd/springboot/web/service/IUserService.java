/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IUserService
 * Author:   admin
 * Date:     2019/3/2 15:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.service;

import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.User;
import com.szxfd.springboot.web.entity.UserCustom;
import com.szxfd.springboot.web.entity.UserQueryVo;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/2
 * @since 1.0.0
 */
public interface IUserService {

    /**
     * 综合条件查询用户列表
     *
     * @param userQueryVo
     * @return
     */
    List<UserCustom> queryUserList(UserQueryVo userQueryVo);

    /**
     * 综合查询用户数量
     *
     * @param userQueryVo
     * @return
     */
    int queryUserCount(UserQueryVo userQueryVo);

//    User queryUserById(UserCustom userCustom);
//
//    List<User> queryUserByName(UserCustom userCustom);

    boolean updateUser(User user) throws Exception;

    BaseResponse<UserCustom> queryUserAndLotteryes(UserCustom userCustom);

    BaseResponse<Integer> registerUser(UserCustom userCustom);
}