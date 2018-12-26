package com.ssm.service;

import com.ssm.domain.Test;

import java.util.List;
import java.util.Map;

public interface TestService {
    public Test getById(int id);
    public Map<String,Object> getMap(Integer id);
    public int addTest(Test test);
    public List<Test> queryTestsByConditions(Map<String,Object> map);
    public int removeTestById(Integer id);
    public int removeTestsByIds(List<Integer> ids);
    public int updateTest(Test test);
    public Map getContent(String content);
}
