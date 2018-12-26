package com.ssm.dao;

import com.ssm.domain.Test;

import java.util.Map;

public interface TestMapper extends ICommonDao{

    Map<String,Object> getMap(Integer id);
    public Map getContent(String content);
}