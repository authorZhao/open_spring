package com.qdz;

import com.qdz.config.QdzSpringApplicationContext;
import com.qdz.frameWork.annotation.QdzComponentScan;
import com.qdz.test.controller.GoodsController;

@QdzComponentScan("com.qdz.test")
public class RunApp {
    public static void main(String[] args) {
        QdzSpringApplicationContext.run(RunApp.class,args);
        GoodsController goodsController = (GoodsController)QdzSpringApplicationContext.getBean("asd");

        goodsController.say(null);

    }
}
