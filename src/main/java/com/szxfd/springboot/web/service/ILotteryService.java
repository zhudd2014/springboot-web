/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ILotteryManager
 * Author:   admin
 * Date:     2019/3/21 23:48
 * Description: 抽奖活动
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.service;

import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.Lottery;
import com.szxfd.springboot.web.entity.LotteryCustom;
import com.szxfd.springboot.web.entity.LotteryQueryVo;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈抽奖活动〉
 *
 * @author admin
 * @create 2019/3/21
 * @since 1.0.0
 */
public interface ILotteryService {

    /**
     * 创建
     *
     * @param lotteryCustom
     * @return
     */
    BaseResponse<Integer> create(LotteryCustom lotteryCustom);

    /**
     * 修改
     *
     * @param lotteryCustom
     * @return
     */
    BaseResponse<Boolean> updateById(LotteryCustom lotteryCustom);

    /**
     * 删除
     *
     * @param lotteryCustom
     * @return
     */
    BaseResponse<Boolean> deleteById(LotteryCustom lotteryCustom);

    /**
     * 通过id查询
     *
     * @param lotteryCustom
     * @return
     */
    BaseResponse<LotteryCustom> queryById(LotteryCustom lotteryCustom);

    /**
     * 综合查询
     *
     * @param lotteryQueryVo
     * @return
     */
    BaseResponse<List<LotteryCustom>> queryList(LotteryQueryVo lotteryQueryVo);

    /**
     * 查询数量
     *
     * @param lotteryQueryVo
     * @return
     */
    BaseResponse<Integer> queryLotteryCount(LotteryQueryVo lotteryQueryVo);

//    /**
//     * 设置开奖方式
//     *
//     * @param lotteryCustom
//     * @return
//     */
//    BaseResponse<Boolean> updateLotteryWay(LotteryCustom lotteryCustom);

    /**
     * 查询指定活动的所有参与者
     *
     * @param lotteryCustom
     * @return
     */
    BaseResponse<LotteryCustom> queryLotteryAndUsersByLotteryId(LotteryCustom lotteryCustom);

    /**
     * 设置开奖方式
     *
     * @param lotteryCustom
     * @return
     */
    BaseResponse<Boolean> setOpenType(LotteryCustom lotteryCustom);

    /**
     * 设置中奖人
     *
     * @param lotteryCustom
     * @return
     */
    BaseResponse<Boolean> updateAwardsAndWinners(LotteryCustom lotteryCustom);

    List<Lottery> queryLotteryList();

    int insertLottery(Lottery lottery);

    int updateLottery(Lottery lottery);

    int deleteLottery(int id);
}