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
package com.phone.demo.springboot201903021433.service;

import com.phone.demo.springboot201903021433.domain.User;

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

    List<User> findAllUser();

    List<User> findUserByName(String name);
}