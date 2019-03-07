package com.test.ssm.service;

import com.github.pagehelper.PageInfo;
import com.test.ssm.pojo.PayChannel;

import java.util.List;

public interface PayService {
    PageInfo<PayChannel> getAllPayPage(String name, Integer pageNum, Integer pageSize);
    List<PayChannel> getAllPay(String name);
    PayChannel getPayById(Integer id);
    void updatePay(PayChannel payChannel);
}
