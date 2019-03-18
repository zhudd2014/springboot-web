/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PrizeQueryVo
 * Author:   admin
 * Date:     2019/3/17 23:36
 * Description: 奖品包装类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈奖品包装类〉
 *
 * @author admin
 * @create 2019/3/17
 * @since 1.0.0
 */
public class PrizeQueryVo {

    /**
     * 奖品id
     */
    private List<Integer> ids;

    /**
     * 奖品信息
     */
    private PrizeCustom prizeCustom;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public PrizeCustom getPrizeCustom() {
        return prizeCustom;
    }

    public void setPrizeCustom(PrizeCustom prizeCustom) {
        this.prizeCustom = prizeCustom;
    }

    @Override
    public String toString() {
        return "PrizeQueryVo{" +
                "ids=" + ids +
                ", prizeCustom=" + prizeCustom +
                '}';
    }
}