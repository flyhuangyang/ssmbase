package com.ssm.service;

import com.ssm.domain.TestEnum;

public interface TestEnumService {

    public TestEnum getById(int id);

    public int add(TestEnum testEnum);
}
