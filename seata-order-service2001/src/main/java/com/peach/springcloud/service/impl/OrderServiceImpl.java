package com.peach.springcloud.service.impl;

import com.peach.springcloud.entity.TOrder;
import com.peach.springcloud.mapper.TAccountMapper;
import com.peach.springcloud.mapper.TOrderMapper;
import com.peach.springcloud.mapper.TStorageMapper;
import com.peach.springcloud.service.AccountService;
import com.peach.springcloud.service.OrderService;
import com.peach.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("OrderService")
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    TOrderMapper orderMapper;
    @Autowired
    AccountService accountService;
    @Autowired
    StorageService storageService;

    @Override
    @GlobalTransactional
    public Integer create(TOrder order) {
        if (order != null)
            order.setStatus(0);
        log.info("开始创建订单");
        orderMapper.insertSelective(order);

        log.info("订单微服务开始扣减库存");
        storageService.update(order.getProduct_id(),order.getCount());

        log.info("订单微服务开始扣减金额");
        accountService.update(order.getUser_id(),order.getMoney());

        log.info("修改订单状态");
        order.setStatus(1);
        int age = 10/0;
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public TOrder getOrder(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer update(TOrder order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }
}
