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
package com.phone.demo.springboot201903021433.dao;

import com.phone.demo.springboot201903021433.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 使用mybatis实现对数据库的操作接口
 *
 * @author admin
 * @create 2019/3/2
 * @since 1.0.0
 */
@Mapper
public interface IUserMapper {

    @Select("SELECT * FROM user;")
    List<User> queryAllUser();

    /**
     * 这里在sql中对形参取值必须要使用value，不能使用形参名name，否则取不到值
     *
     * @param name
     * @return
     */
    @Select("SELECT * FROM user where username like '%${value}%'")
    List<User> queryUserByName(String name);
}