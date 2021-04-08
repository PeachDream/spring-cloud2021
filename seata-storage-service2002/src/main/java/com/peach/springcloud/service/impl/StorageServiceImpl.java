package com.peach.springcloud.service.impl;

import com.peach.springcloud.mapper.TStorageMapper;
import com.peach.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("StorageService")
public class StorageServiceImpl implements StorageService {

    @Autowired
    TStorageMapper storageMapper;

    @Override
    @GlobalTransactional //开启全局事务处理
    public Integer reduceStorage(Long id, Integer number) {
        return storageMapper.reduceStorage(id,number);
    }
}
