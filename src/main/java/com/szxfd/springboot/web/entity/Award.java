/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Award
 * Author:   admin
 * Date:     2019/3/23 22:09
 * Description: 奖项设置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

/**
 * 〈一句话功能简述〉<br>
 * 〈奖项设置〉
 *
 * @author admin
 * @create 2019/3/23
 * @since 1.0.0
 */
public class Award {

    /**
     * 一等奖
     */
    private AwardItem award1;
    /**
     * 二等奖
     */
    private AwardItem award2;
    /**
     * 三等奖
     */
    private AwardItem award3;
    /**
     * 四等奖
     */
    private AwardItem award4;
    /**
     * 五等奖
     */
    private AwardItem award5;

    public AwardItem getAward1() {
        return award1;
    }

    public void setAward1(AwardItem award1) {
        this.award1 = award1;
    }

    public AwardItem getAward2() {
        return award2;
    }

    public void setAward2(AwardItem award2) {
        this.award2 = award2;
    }

    public AwardItem getAward3() {
        return award3;
    }

    public void setAward3(AwardItem award3) {
        this.award3 = award3;
    }

    public AwardItem getAward4() {
        return award4;
    }

    public void setAward4(AwardItem award4) {
        this.award4 = award4;
    }

    public AwardItem getAward5() {
        return award5;
    }

    public void setAward5(AwardItem award5) {
        this.award5 = award5;
    }

    @Override
    public String toString() {
        return "Award{" +
                "award1=" + award1 +
                ", award2=" + award2 +
                ", award3=" + award3 +
                ", award4=" + award4 +
                ", award5=" + award5 +
                '}';
    }
}