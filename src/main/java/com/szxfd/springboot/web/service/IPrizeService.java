package com.szxfd.springboot.web.service;

import com.szxfd.springboot.web.entity.Prize;

import java.util.List;

public interface IPrizeService {

    /**
     * 查询奖品列表
     *
     * @return
     */
    List<Prize> queryPrizes();

    int insert(Prize prize);

    int update(Prize prize);

    int deletePrize(int id);
}
