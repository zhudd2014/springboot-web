package com.szxfd.springboot.web.dao;

import com.szxfd.springboot.web.entity.Lottery;
import com.szxfd.springboot.web.entity.LotteryCustom;
import com.szxfd.springboot.web.entity.LotteryQueryVo;

import java.util.List;


public interface LotteryMapper {

    /**
     * 添加抽奖活动
     *
     * @param lotteryCustom
     * @return
     */
    int insert(LotteryCustom lotteryCustom);

    /**
     * 删除抽奖活动
     *
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 修改抽奖活动
     *
     * @param lotteryCustom
     * @return
     */
    int updateById(LotteryCustom lotteryCustom);

    /**
     * 通过id查询抽奖活动
     *
     * @param id
     * @return
     */
    LotteryCustom queryById(int id);

    /**
     * 综合查询
     *
     * @param lotteryQueryVo
     * @return
     */
    List<LotteryCustom> queryLotteryList(LotteryQueryVo lotteryQueryVo);

    /**
     * 查询数量
     *
     * @param lotteryQueryVo
     * @return
     */
    int queryLotteryCount(LotteryQueryVo lotteryQueryVo);

    /**
     * 设置开奖方式
     *
     * @param lotteryCustom
     * @return
     */
    int setOpenType(LotteryCustom lotteryCustom);

    /**
     * 设置活动状态
     *
     * @param status
     * @return
     */
    int setStatus(int status);

    /**
     * 设置奖项及中奖人
     *
     * @param lotteryCustom
     * @return
     */
    int updateAwardsAndWinners(LotteryCustom lotteryCustom);

    /**
     * 查询指定活动的所有参与者
     *
     * @param lotteryId
     * @return
     */
    LotteryCustom queryLotteryAndUsers(int lotteryId);


    List<Lottery> getLotteryList();

    int insertLottery(Lottery lottery);

    int updateLottery(Lottery lottery);

    int deleteLottery(int id);

}