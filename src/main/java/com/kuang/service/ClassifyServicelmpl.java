package com.kuang.service;

import com.kuang.dao.ClassifyMapper;
import com.kuang.pojo.Classify;

import java.util.List;

public class ClassifyServicelmpl implements ClassifyService {
    private ClassifyMapper classifyMapper;

    public void setClassifyMapper(ClassifyMapper classifyMapper) {
        this.classifyMapper = classifyMapper;
    }

    public List<Classify> queryClassifyByParentId() {
        return classifyMapper.queryClassifyByParentId();
    }
}
