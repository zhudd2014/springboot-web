/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PrizeController
 * Author:   admin
 * Date:     2019/3/19 0:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.controller;

import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.PrizeCustom;
import com.szxfd.springboot.web.entity.PrizeQueryVo;
import com.szxfd.springboot.web.service.IPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/19
 * @since 1.0.0
 */
@RestController
@RequestMapping("/prize")
public class PrizeController {

    @Autowired
    private IPrizeService prizeService;

    /**
     * 添加奖品
     *
     * @param prizeCustom
     * @return
     */
    @RequestMapping("/add")
    public BaseResponse<Integer> add(@RequestBody PrizeCustom prizeCustom) {
        return prizeService.insert(prizeCustom);
    }

    @RequestMapping("/queryById")
    public BaseResponse<PrizeCustom> queryById(@RequestBody PrizeCustom prizeCustom) {
        return prizeService.queryPrizeById(prizeCustom);
    }

    /**
     * 通过title匹配奖品
     *
     * @param prizeCustom
     * @return
     */
    @RequestMapping("/queryByTitle")
    public BaseResponse<List<PrizeCustom>> queryByTitle(@RequestBody PrizeCustom prizeCustom) {
        return prizeService.queryPrizeByTitle(prizeCustom.getTitle());
    }

    @RequestMapping("/updatePrize")
    public BaseResponse<Boolean> updatePrize(@RequestBody PrizeCustom prizeCustom) {
        return prizeService.update(prizeCustom);
    }

    @RequestMapping("/queryPrizeList")
    public BaseResponse<List<PrizeCustom>> queryPrizeList(@RequestBody(required = false) PrizeQueryVo prizeQueryVo) {
        return prizeService.queryPrizeList(prizeQueryVo);
    }

    @RequestMapping("/queryPrizeCount")
    public BaseResponse<Integer> queryPrizeCount(@RequestBody(required = false) PrizeQueryVo prizeQueryVo) {
        return prizeService.queryPrizeCount(prizeQueryVo);
    }

}