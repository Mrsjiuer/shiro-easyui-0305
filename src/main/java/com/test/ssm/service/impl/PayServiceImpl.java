package com.test.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.ssm.dao.PayDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.ssm.pojo.PayChannel;
import com.test.ssm.service.PayService;

import java.util.List;
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayDAO payDAO;

    @Override
    public PageInfo<PayChannel> getAllPayPage(PayChannel payChannel, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(payDAO.getAllPay(payChannel));
    }
    @Override
    public PayChannel getPayById(Integer id) {
        return payDAO.getPayById(id);
    }

    @Override
    public void updatePay(PayChannel payChannel) {
        payDAO.updatePay(payChannel);
    }
}
