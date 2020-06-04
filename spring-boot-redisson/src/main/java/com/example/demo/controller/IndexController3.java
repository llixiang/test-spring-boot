package com.example.demo.controller;

import org.redisson.Redisson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

/**
 * @author LiXiang
 * @date 2020/6/3 10:13
 */
@Controller
@RequestMapping
public class IndexController3 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Redisson redisson;

    @RequestMapping("/deduct_stock3")
    public String deductStock() throws InterruptedException {
        String lockKey = "lockKey";
        try {
            //setnx(key,value)
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "lxx");
//           //设置超时时间
            stringRedisTemplate.expire(lockKey, 10, TimeUnit.SECONDS);


            if (!result) {
                return "error";
            }

            //jedis.get("stock")
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                //jedis.set(key.value)
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减成功，剩余名额为：" + realStock);
            } else {
                System.out.println("扣减失败，剩余名额不足");
            }

        } finally {
            stringRedisTemplate.delete(lockKey);
        }


        return "end";

    }
}
