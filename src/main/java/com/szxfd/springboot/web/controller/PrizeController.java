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

import com.szxfd.springboot.web.entity.Prize;
import com.szxfd.springboot.web.entity.Result;
import com.szxfd.springboot.web.service.IPrizeService;
import com.szxfd.springboot.web.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/19
 * @since 1.0.0
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/prize")
public class PrizeController {

    @Autowired
    private IPrizeService prizeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result queryPrizeList() {
        return ResultUtil.success(prizeService.queryPrizes());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result createPrize(@RequestBody Prize prize) {
        int index = prizeService.insert(prize);
        return ResultUtil.success(prize);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable String id, @RequestBody Prize prize) {
        int index = prizeService.update(prize);
        return ResultUtil.success(prize);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable int id) {
        int index = prizeService.deletePrize(id);
        return ResultUtil.success();
    }

}