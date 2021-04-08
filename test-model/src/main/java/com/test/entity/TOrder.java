package com.test.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
    * 订单表
    */
@Getter
@Setter
@ToString
public class TOrder implements Serializable {
    private Long id;

    /**
    * 用户id
    */
    private Long userId;

    /**
    * 产品id
    */
    private Long productId;

    /**
    * 数量
    */
    private Integer count;

    /**
    * 金额
    */
    private Long money;

    /**
    * 订单状态:  0:创建中 1:已完结
    */
    private Integer status;

    private static final long serialVersionUID = 1L;
}