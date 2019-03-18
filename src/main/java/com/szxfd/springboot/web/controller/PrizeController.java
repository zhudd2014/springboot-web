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
import com.szxfd.springboot.web.service.IPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/add")
    public BaseResponse add(@RequestBody PrizeCustom prizeCustom) {
//        PrizeCustom prizeCustom = new PrizeCustom();
//        prizeCustom.setTitle(title);
//        prizeCustom.setDesc(desc);
//        prizeCustom.setPrice(price);
//        prizeCustom.setQuantity(quantity);
        return prizeService.add(prizeCustom);
    }

    @RequestMapping("/queryById")
    public BaseResponse queryById(@RequestBody PrizeCustom prizeCustom) {
        return prizeService.queryById(prizeCustom.getId());
    }

    @RequestMapping("/queryByTitle")
    public BaseResponse queryByTitle(@RequestBody PrizeCustom prizeCustom) {
        return prizeService.queryByTitle(prizeCustom.getTitle());
    }

}