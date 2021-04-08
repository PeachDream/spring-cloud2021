package com.peach.springcloud.serviceImpl;

import com.peach.springcloud.entity.Payment;
import com.peach.springcloud.mapper.PaymentMapper;
import com.peach.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("PaymentService")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentMapper mapper;

    @Override
    public Payment get(Long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
