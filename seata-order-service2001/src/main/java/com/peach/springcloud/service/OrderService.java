package com.peach.springcloud.service;

import com.peach.springcloud.entity.TOrder;

public interface OrderService {
    Integer create(TOrder order);

    TOrder getOrder(Long id);

    Integer update(TOrder order);
}
