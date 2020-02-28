package com.kuang.service;

import com.kuang.pojo.Classify;

import java.util.List;

public interface ClassifyService {
    List<Classify> queryClassifyByParentId();
}
