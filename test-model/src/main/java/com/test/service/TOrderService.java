package com.test.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.test.entity.TOrder;
import com.test.mapper.TOrderMapper;
@Service
public class TOrderService{

    @Resource
    private TOrderMapper tOrderMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return tOrderMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TOrder record) {
        return tOrderMapper.insert(record);
    }

    
    public int insertSelective(TOrder record) {
        return tOrderMapper.insertSelective(record);
    }

    
    public TOrder selectByPrimaryKey(Long id) {
        return tOrderMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TOrder record) {
        return tOrderMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TOrder record) {
        return tOrderMapper.updateByPrimaryKey(record);
    }

}
