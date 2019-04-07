/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserMapper
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
public interface UserMapper {

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

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    User queryUserById(int id) throws Exception;

    /**
     * 通过名字模糊查询
     *
     * @param name
     * @return
     * @throws Exception
     */
    List<User> queryUserByName(String name) throws Exception;

    /**
     * 根据id修改用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    Integer updateUser(User user) throws Exception;

    /**
     * 查询指定用户信息及参加的所有活动信息
     *
     * @return
     */
    UserCustom queryUserAndLotteryes(int id);

    /**
     * 增加记录
     *
     * @param userCustom
     * @return
     */
    int insertUser(UserCustom userCustom);

    /**
     * 查询用户，全匹配查询，用于登录
     *
     * @param userCustom
     */
    int queryUserByUsernameAndPassword(UserCustom userCustom);
}