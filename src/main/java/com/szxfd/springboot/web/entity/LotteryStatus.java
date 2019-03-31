/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LotteryStatus
 * Author:   admin
 * Date:     2019/3/31 17:36
 * Description: 开奖状态
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

/**
 * 〈一句话功能简述〉<br>
 * 〈开奖状态〉
 *
 * @author admin
 * @create 2019/3/31
 * @since 1.0.0
 */
public enum LotteryStatus {

    NO_START(1, "未开始"), WAIT_PUBLISH(2, "待开奖"), HAS_PUBLISH(3, "已开奖"),
    NONE(0, "未知状态");

    private int code;
    private String desc;

    LotteryStatus(int code, String desc) {
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

    public static LotteryStatus code2Status(int code) {
        LotteryStatus statuses[] = values();
        for (LotteryStatus status : statuses) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return NONE;
    }

}