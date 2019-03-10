package com.szxfd.springboot.web.entity;


import lombok.Data;

import java.util.Date;

@Data

public class Lottery {

    private Integer id;

    private String lotteryName;

    private String lotteryDesc;

    private Integer lotteryDrawType;

    private String lotteryImg;

    private Date lotteryDrawTime;
}
