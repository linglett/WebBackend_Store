package com.kuang.dao;

import com.kuang.pojo.Classify;

import java.util.List;

public interface ClassifyMapper {
    //查询全部分类
    List<Classify> queryClassifyByParentId();
}
