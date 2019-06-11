package com.qdz.test.service.impl;

import com.qdz.frameWork.annotation.QdzService;
import com.qdz.test.service.GoodsService;
@QdzService
public class GoodsServiceImpl implements GoodsService {
    @Override
    public String say() {
        return "带嘎哈，我系渣渣辉";
    }
}
