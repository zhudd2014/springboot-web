/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RespError
 * Author:   admin
 * Date:     2019/3/7 23:23
 * Description: 响应错误吗
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

/**
 * 〈一句话功能简述〉<br>
 * 〈响应错误码〉
 *
 * @author admin
 * @create 2019/3/7
 * @since 1.0.0
 */
public enum RespError {

    MYBATIS_ERROR("0000", "mybatis错误");

    private String code;
    private String msg;

    RespError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}