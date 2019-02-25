package com.szxfd.springboot.web.dao;

import com.szxfd.springboot.web.entity.Lottery;


public interface LotteryDao {


    Lottery selectByPrimaryKey(Integer id);

}