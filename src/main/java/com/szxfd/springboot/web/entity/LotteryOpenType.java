/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LotteryOpenType
 * Author:   admin
 * Date:     2019/3/31 17:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

/**
 * 〈一句话功能简述〉<br>
 * 〈开奖方式〉
 *
 * @author admin
 * @create 2019/3/31
 * @since 1.0.0
 */
public enum LotteryOpenType {

    MANUAL(1, "手动开奖"), SCHEDULED_TIME(2, "按时间开奖"), SCHEDULED_QUANTITY(3, "按人数开奖"),
    NONE(0, "没有设置开奖方式");

    private int code;
    private String desc;

    LotteryOpenType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static LotteryOpenType codeToType(int code) {
        LotteryOpenType types[] = values();
        for (LotteryOpenType type : types) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return NONE;
    }
}