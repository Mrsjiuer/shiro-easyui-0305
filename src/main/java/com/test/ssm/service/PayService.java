package com.test.ssm.service;

import com.github.pagehelper.PageInfo;
import com.test.ssm.pojo.PayChannel;

import java.util.List;

public interface PayService {
    PageInfo<PayChannel> getAllPayPage(PayChannel payChannel,Integer pageNum, Integer pageSize);
    PayChannel getPayById(Integer id);
    void updatePay(PayChannel payChannel);
}
