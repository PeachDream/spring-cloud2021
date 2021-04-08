package com.peach.springcloud.service.impl;

import com.peach.springcloud.entity.TAccount;
import com.peach.springcloud.mapper.TAccountMapper;
import com.peach.springcloud.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AccountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    TAccountMapper accountMapper;


    @GlobalTransactional
    @Override
    public Integer reduceAccount(Long id, Long number) {
        return accountMapper.reduceSccount(id,number);
    }
}
