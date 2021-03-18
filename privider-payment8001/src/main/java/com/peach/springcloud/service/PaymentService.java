package com.peach.springcloud.service;

import com.peach.springcloud.entity.Payment;

public interface PaymentService {

    int addPayment(Payment payment);

    Payment selectById(Long id);
}
