package com.qdz.test.controller;

import com.qdz.frameWork.annotation.QdzAutowired;
import com.qdz.frameWork.annotation.QdzController;
import com.qdz.test.service.GoodsService;

@QdzController("asd")
public class GoodsController {

    @QdzAutowired("goodsServiceImpl")
    private GoodsService goodsService;
    public void say(String args) {
        System.out.println(goodsService.say());
    }

}
