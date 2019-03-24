/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AwardPrize
 * Author:   admin
 * Date:     2019/3/23 22:23
 * Description: 奖项中设置的奖品
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

/**
 * 〈一句话功能简述〉<br>
 * 〈奖项中设置的奖品〉
 *
 * @author admin
 * @create 2019/3/23
 * @since 1.0.0
 */
public class AwardPrize {

    /**
     * 奖品id
     */
    private int prizeId;
    /**
     * 奖品数量
     */
    private int quantity;

    public int getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(int prizeId) {
        this.prizeId = prizeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AwardPrize{" +
                "prizeId=" + prizeId +
                ", quantity=" + quantity +
                '}';
    }
}