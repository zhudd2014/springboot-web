/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseResponse
 * Author:   admin
 * Date:     2019/3/7 23:19
 * Description: 响应体
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

/**
 * 〈一句话功能简述〉<br>
 * 〈响应体〉
 *
 * @author admin
 * @create 2019/3/7
 * @since 1.0.0
 */
public class BaseResponse<T> {

    private boolean success;
    private String errorCode;
    private String errorMsg;
    private T obj;

    public BaseResponse() {
    }

    public BaseResponse(boolean success, T obj) {
        this.success = success;
        this.obj = obj;
    }

    public BaseResponse(String errorCode, String errorMsg) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "success=" + success +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", obj=" + obj +
                '}';
    }
}