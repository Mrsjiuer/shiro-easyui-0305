package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.test.ssm.pojo.Role;
import com.test.ssm.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.test.ssm.pojo.PayChannel;
import com.test.ssm.service.PayService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PayController {

    @Autowired
   private PayService payService;


    @RequestMapping("go_updatePay.html")
    public String goUpdate(Integer id, Model model) {
        PayChannel payChannel = payService.getPayById(id);
        model.addAttribute("payChannel", payChannel);
        return "updatePay";
    }

    @RequestMapping("updatePay.html")
    @ResponseBody
    public String update(PayChannel payChannel) {
        payService.updatePay(payChannel);
        return "ok";

    }

    @RequestMapping("listPay.html")
    public String page() {
        return "listPay";
    }

    @RequestMapping("tablePay.html")
//    @ResponseBody
//    public TableData table(PayChannel payChannel, Integer page, Integer rows) {
//        PageInfo<PayChannel> pageInfo = payService.getAllPayPage(payChannel, page, rows);
//        return new TableData(pageInfo.getTotal(), pageInfo.getList());
//    }
    @ResponseBody
    public Map<String, Object> payChannel(PayChannel payChannel,Integer page, Integer rows) {
        Map<String, Object> result = new HashMap<>();
        PageInfo<PayChannel> pageInfo = payService.getAllPayPage(payChannel, page, rows);
        result.put("total", pageInfo.getTotal());//一共多少条
        result.put("rows", pageInfo.getList());
        return result;
    }
}
