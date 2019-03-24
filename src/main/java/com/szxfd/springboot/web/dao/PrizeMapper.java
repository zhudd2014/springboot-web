package com.szxfd.springboot.web.dao;

import com.szxfd.springboot.web.entity.PrizeCustom;
import com.szxfd.springboot.web.entity.PrizeQueryVo;

import java.util.List;

/**
 * 奖品
 */
public interface PrizeMapper {

    /**
     * 添加
     *
     * @param prizeCustom
     * @return
     */
    int insert(PrizeCustom prizeCustom);

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    int removeInLogical(int id);

    /**
     * 修改
     *
     * @param prizeCustom
     * @return
     */
    int update(PrizeCustom prizeCustom);

    /**
     * 查询奖品
     *
     * @param id
     * @return
     */
    PrizeCustom queryPrizeById(int id);

    /**
     * 根据奖品标题查询
     *
     * @param title
     * @return
     */
    List<PrizeCustom> queryPrizeByTitle(String title);

    /**
     * 查询奖品
     *
     * @param prizeQueryVo
     * @return
     */
    List<PrizeCustom> queryPrizeList(PrizeQueryVo prizeQueryVo);

    /**
     * 查询奖品数量
     *
     * @return
     */
    int queryPrizeCount(PrizeQueryVo prizeQueryVo);
}
