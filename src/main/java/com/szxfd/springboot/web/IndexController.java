package com.szxfd.springboot.web;

import com.szxfd.springboot.web.dao.LotteryDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Resource
    private LotteryDao lotteryDao;


    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "hello ,demo start";
    }

    @RequestMapping("/lottery")
    @ResponseBody
    public String lottery(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        return lotteryDao.selectByPrimaryKey(id).toString();
    }
}
