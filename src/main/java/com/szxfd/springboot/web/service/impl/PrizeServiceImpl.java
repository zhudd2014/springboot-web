/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PrizeService
 * Author:   admin
 * Date:     2019/3/17 23:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.service.impl;

import com.szxfd.springboot.web.dao.PrizeMapper;
import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.PrizeCustom;
import com.szxfd.springboot.web.entity.PrizeQueryVo;
import com.szxfd.springboot.web.service.IPrizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/17
 * @since 1.0.0
 */
@Service
public class PrizeServiceImpl implements IPrizeService {

    @Resource
    private PrizeMapper prizeMapper;

    @Override
    public BaseResponse add(PrizeCustom prizeCustom) {
        BaseResponse response = new BaseResponse();
        if (null == prizeCustom) {
            response.setSuccess(false);
            response.setErrorMsg("prizeCustom为空");
            return response;
        }
        if (null == prizeCustom.getTitle() || "" == prizeCustom.getTitle()) {
            response.setSuccess(false);
            response.setErrorMsg("title为空");
            return response;
        }
        if (null == prizeCustom.getDesc() || "" == prizeCustom.getDesc()) {
            response.setSuccess(false);
            response.setErrorMsg("desc");
            return response;
        }
        if (prizeCustom.getPrice() < 0) {
            response.setSuccess(false);
            response.setErrorMsg("price不能为负数");
            return response;
        }
        if (prizeCustom.getQuantity() < 0) {
            response.setSuccess(false);
            response.setErrorMsg("quantity不能为负数");
            return response;
        }
        //先查询奖品是否已经存在
        int result = prizeMapper.insert(prizeCustom);
        if (result >= 0) {
            response.setSuccess(true);
        } else {
            response.setSuccess(false);
            response.setErrorMsg("插入数据库失败");
        }
        return response;
    }

    @Override
    public boolean remove(int id) {
        //先查询奖品是否已经存在
        PrizeCustom prizeCustom = prizeMapper.queryPrizeById(id);
        if (null == prizeCustom) {
            return false;
        }
        int result = prizeMapper.removeInLogical(id);
        return result >= 0;
    }

    @Override
    public boolean update(PrizeCustom prizeCustom) {
        return false;
    }

    @Override
    public BaseResponse<PrizeCustom> queryById(int id) {
        BaseResponse<PrizeCustom> response = new BaseResponse<>();
        PrizeCustom prizeCustom = prizeMapper.queryPrizeById(id);
        response.setObj(prizeCustom);
        return response;
    }

    @Override
    public BaseResponse<List<PrizeCustom>> queryByTitle(String title) {
        BaseResponse<List<PrizeCustom>> response = new BaseResponse<>();
        List<PrizeCustom> prizeCustoms = prizeMapper.queryPrizeByTitle(title);
        response.setObj(prizeCustoms);
        return response;
    }

    @Override
    public List<PrizeCustom> queryList(PrizeQueryVo prizeQueryVo) {
        return null;
    }
}