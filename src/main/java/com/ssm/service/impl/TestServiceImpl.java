package com.ssm.service.impl;

import com.ssm.dao.TestMapper;
import com.ssm.domain.Test;
import com.ssm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public Test getById(int id) {

        return testMapper.queryEntityById(id);
    }

    @Override
    public Map<String, Object> getMap(Integer id) {
        return testMapper.getMap(id);
    }

    @Override
    public int addTest(Test test) {
        return testMapper.insertEntity(test);
    }

    @Override
    public List<Test> queryTestsByConditions(Map<String, Object> map) {
        return testMapper.queryEntityByConditions(map);
    }

    @Override
    public int removeTestById(Integer id) {
        return testMapper.removeEntity(id);
    }

    @Override
    public int removeTestsByIds(List<Integer> ids) {
        return 0;
    }

    @Override
    public int updateTest(Test test) {
        return testMapper.updateEntity(test);
    }

    public Map getContent(String content){
        return testMapper.getContent(content);
    }
}
