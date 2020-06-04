package com.example.demo.functional.interfaces;

import java.util.function.Consumer;

/**
 * @author LiXiang
 * @date 2020/6/1 17:27
 */
public class Consumers {

    /**
     * Consumer 表示要对单个输入参数执行的操作
     *
     * @return
     */
    public Consumer<String> getConsume() {
        Consumer<String> consumer = new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        return consumer;
    }
}
