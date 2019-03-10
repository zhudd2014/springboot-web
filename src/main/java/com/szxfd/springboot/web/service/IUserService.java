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

    List<UserCustom> queryUserList(UserQueryVo userQueryVo);

    int queryUserCount(UserQueryVo userQueryVo);

    User queryUserById(int id) throws Exception;

    List<User> queryUserByName(String name) throws Exception;

    boolean insertUser(User user) throws Exception;

    boolean deleteUser(int id) throws Exception;

    boolean updateUser(User user) throws Exception;
}