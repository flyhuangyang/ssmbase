package com.ssm.dao;

import java.util.List;
import java.util.Map;

public interface ICommonDao {

    <T> T queryEntityById(Integer id);

    <T> T queryEntityByCondition();

    <T> List<T> queryEntityByConditions(Map<String,Object> map);

    <T> int insertEntity(T entity);

    <T> int updateEntity(T entity);

    <T> int updateEntityBatch(T entity);

    <T> int removeEntity(Integer id);

    <T> int removeEntityBatch(List<Integer> list);
}
