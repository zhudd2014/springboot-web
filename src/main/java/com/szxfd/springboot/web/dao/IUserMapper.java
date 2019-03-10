/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IUserMapper
 * Author:   admin
 * Date:     2019/3/2 14:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.dao;

import com.szxfd.springboot.web.entity.User;
import com.szxfd.springboot.web.entity.UserCustom;
import com.szxfd.springboot.web.entity.UserQueryVo;

import java.util.List;

/**
 * 使用mybatis实现对数据库的操作接口
 *
 * @author admin
 * @create 2019/3/2
 * @since 1.0.0
 */
public interface IUserMapper {

    /**
     * 用户信息综合查询
     *
     * @param userQueryVo
     * @return
     */
    List<UserCustom> queryUserList(UserQueryVo userQueryVo);

    /**
     * 用户信息综合查询的总数
     *
     * @param userQueryVo
     * @return
     */
    int queryUserCount(UserQueryVo userQueryVo);

    User queryUserById(int id) throws Exception;

    List<User> queryUserByName(String name) throws Exception;

    Integer insertUser(User user) throws Exception;

    Integer deleteUser(int id) throws Exception;

    Integer updateUser(User user) throws Exception;
}