package com.ssm.service.impl;

import com.ssm.dao.TestEnumMapper;
import com.ssm.domain.TestEnum;
import com.ssm.service.TestEnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestEnumServiceImpl implements TestEnumService{

    @Autowired
    private TestEnumMapper testEnumMapper;

    public TestEnum getById(int id){
        return  testEnumMapper.selectByPrimaryKey(id);
    }

    public int add(TestEnum testEnum){
        return testEnumMapper.insert(testEnum);
    }
}
