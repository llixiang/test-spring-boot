package com.example.demo.controller;

import org.redisson.Redisson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LiXiang
 * @date 2020/6/3 10:13
 */
@Controller
@RequestMapping
public class IndexController2 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Redisson redisson;

    @RequestMapping("/deduct_stock2")
    public String deductStock() throws InterruptedException{
        //让其原子化执行  synchronized同步代码块
        synchronized (this) {
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock")); //jedis.get("stock")
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + ""); //jedis.set(key.value)
                System.out.println("扣减成功，剩余名额为：" + realStock);
            } else {
                System.out.println("扣减失败，剩余名额不足");
            }
            return "end";
        }

    }
}
