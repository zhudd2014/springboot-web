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

import com.szxfd.springboot.web.entity.Lottery;
import com.szxfd.springboot.web.entity.Result;
import com.szxfd.springboot.web.service.ILotteryService;
import com.szxfd.springboot.web.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈抽奖活动〉
 *
 * @author admin
 * @create 2019/3/21
 * @since 1.0.0
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @Autowired
    private ILotteryService lotteryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result queryLotteryList() {
        return ResultUtil.success(lotteryService.queryLotteryList());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result createLottery(@RequestBody Lottery lottery) {
        int index = lotteryService.insertLottery(lottery);
        return ResultUtil.success(lottery);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable String id, @RequestBody Lottery lottery) {
        int index = lotteryService.updateLottery(lottery);
        return ResultUtil.success(lottery);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable int id) {
        int index = lotteryService.deleteLottery(id);
        return ResultUtil.success();
    }

}