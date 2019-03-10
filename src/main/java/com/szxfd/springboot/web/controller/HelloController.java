/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HelloController
 * Author:   admin
 * Date:     2019/3/2 14:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/2
 * @since 1.0.0
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("test")
    public String test() {
        System.out.println("test....");
        return "hello spring boot,phone";
    }
}