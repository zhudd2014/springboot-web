package com.szxfd.springboot.web.controller;

import com.szxfd.springboot.web.dao.ILotteryMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Resource
    private ILotteryMapper ILotteryMapper;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "hello ,demo start";
    }

    @RequestMapping("/lottery")
    @ResponseBody
    public String lottery(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        return ILotteryMapper.selectByPrimaryKey(id).toString();
    }
}
