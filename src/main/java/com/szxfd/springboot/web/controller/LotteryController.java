/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LotteryController
 * Author:   admin
 * Date:     2019/3/21 23:21
 * Description: 抽奖活动
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.controller;

import com.alibaba.fastjson.JSON;
import com.szxfd.springboot.web.entity.*;
import com.szxfd.springboot.web.service.ILotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈抽奖活动〉
 *
 * @author admin
 * @create 2019/3/21
 * @since 1.0.0
 */
@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @Autowired
    private ILotteryService lotteryService;

    /**
     * 创建活动
     *
     * @return
     */
    @RequestMapping("/createLottery")
    public BaseResponse<Integer> createLottery(@RequestBody LotteryCustom lotteryCustom) {
        return lotteryService.create(lotteryCustom);
    }

    /**
     * 修改活动
     *
     * @return
     */
    @RequestMapping("/updateLottery")
    public BaseResponse<Boolean> updateLottery(@RequestBody LotteryCustom lotteryCustom) {
        return lotteryService.updateById(lotteryCustom);
    }

    /**
     * 删除活动
     *
     * @return
     */
    @RequestMapping("/deleteLottery")
    public BaseResponse<Boolean> deleteLottery(@RequestBody LotteryCustom lotteryCustom) {
        return lotteryService.deleteById(lotteryCustom);
    }

    /**
     * 查询活动
     *
     * @param lotteryCustom
     * @return
     */
    @RequestMapping("/queryLotteryById")
    public BaseResponse<LotteryCustom> queryLotteryById(@RequestBody LotteryCustom lotteryCustom) {
        return lotteryService.queryById(lotteryCustom);
    }

//    /**
//     * 查询指定user参与的活动
//     */
//    @RequestMapping("/queryLotteryByUserId")
//    public BaseResponse<LotteryCustom> queryLotteryByUserId(@RequestBody LotteryCustom lotteryCustom) {
//        return lotteryService.queryLotteryAndUsersByLotteryId(lotteryCustom);
//    }

    /**
     * 查询参与指定活动的所有人
     */
    @RequestMapping("/queryLotteryAndUsersByLotteryId")
    public BaseResponse<LotteryCustom> queryLotteryAndUsersByLotteryId(@RequestBody LotteryCustom lotteryCustom) {
        return lotteryService.queryLotteryAndUsersByLotteryId(lotteryCustom);
    }

    /**
     * 设置奖项及中奖者
     *
     * @return
     */
    @RequestMapping("/updateAwardsAndWinners")
    public BaseResponse updateAwardsAndWinners(@RequestBody LotteryCustom lotteryCustom) {
        return lotteryService.updateAwardsAndWinners(lotteryCustom);
    }

    public String generateAward() {
        //一等奖
        AwardItem awardItem1 = new AwardItem();
        awardItem1.setPrizes(generatePrizes1());
        awardItem1.setWinerIds(generateWiners1());
        //二等奖
        AwardItem awardItem2 = new AwardItem();
        awardItem2.setPrizes(generatePrizes2());
        awardItem2.setWinerIds(generateWiners2());
        Award award = new Award();
        award.setAward1(awardItem1);
        award.setAward2(awardItem2);
        String awardStr = JSON.toJSONString(award);
        System.out.println("awardStr:" + awardStr);
        return awardStr;
    }

    private List<Integer> generateWiners1() {
        List<Integer> winers = new ArrayList<>();
        winers.add(1);
        return winers;
    }

    private List<AwardPrize> generatePrizes1() {
        AwardPrize awardPrize0 = new AwardPrize();
        awardPrize0.setPrizeId(1);
        awardPrize0.setQuantity(1);
        AwardPrize awardPrize1 = new AwardPrize();
        awardPrize1.setPrizeId(2);
        awardPrize1.setQuantity(2);
        List<AwardPrize> awardPrizes = new ArrayList<>();
        awardPrizes.add(awardPrize0);
        awardPrizes.add(awardPrize1);
        return awardPrizes;
    }

    private List<Integer> generateWiners2() {
        List<Integer> winers = new ArrayList<>();
        winers.add(2);
        winers.add(3);
        return winers;
    }

    private List<AwardPrize> generatePrizes2() {
        AwardPrize awardPrize0 = new AwardPrize();
        awardPrize0.setPrizeId(3);
        awardPrize0.setQuantity(1);
        AwardPrize awardPrize1 = new AwardPrize();
        awardPrize1.setPrizeId(4);
        awardPrize1.setQuantity(3);
        AwardPrize awardPrize2 = new AwardPrize();
        awardPrize2.setPrizeId(5);
        awardPrize2.setQuantity(10);
        List<AwardPrize> awardPrizes = new ArrayList<>();
        awardPrizes.add(awardPrize0);
        awardPrizes.add(awardPrize1);
        awardPrizes.add(awardPrize2);
        return awardPrizes;
    }

}