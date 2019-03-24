/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AwardItem
 * Author:   admin
 * Date:     2019/3/23 22:11
 * Description: 单个奖项摄制
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈单个奖项设置〉
 *
 * @author admin
 * @create 2019/3/23
 * @since 1.0.0
 */
public class AwardItem {

    /**
     * 奖项中包含的奖品集合
     */
    private List<AwardPrize> prizes;
    /**
     * 中奖者userId
     */
    private List<Integer> winerIds;

    public List<AwardPrize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<AwardPrize> prizes) {
        this.prizes = prizes;
    }

    public List<Integer> getWinerIds() {
        return winerIds;
    }

    public void setWinerIds(List<Integer> winerIds) {
        this.winerIds = winerIds;
    }

    @Override
    public String toString() {
        return "AwardItem{" +
                "prizes=" + prizes +
                ", winerIds=" + winerIds +
                '}';
    }
}