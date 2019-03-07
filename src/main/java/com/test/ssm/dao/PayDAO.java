package com.test.ssm.dao;

import org.springframework.stereotype.Repository;
import com.test.ssm.pojo.PayChannel;

import java.util.List;

@Repository
public interface PayDAO {
    List<PayChannel> getAllPay(String name);
    PayChannel getPayById(Integer id);
    void updatePay(PayChannel payChannel);
}
