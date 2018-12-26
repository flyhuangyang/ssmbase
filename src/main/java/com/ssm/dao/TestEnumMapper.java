package com.ssm.dao;

import com.ssm.domain.TestEnum;

import java.util.Map;

public interface TestEnumMapper extends ICommonDao{
    public TestEnum selectByPrimaryKey(int id);
    public int insert(TestEnum testEnum);
}