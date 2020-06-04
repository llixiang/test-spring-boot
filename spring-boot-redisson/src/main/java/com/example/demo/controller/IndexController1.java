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
//存在并发量高的问题，此只适用于单体架构
@Controller
@RequestMapping
public class IndexController1 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Redisson redisson;

    @RequestMapping("/deduct_stock1")
    public String deductStock() {
        //让其原子化执行  synchronized同步代码块
        synchronized (this) {
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
            return "end";
        }

    }
}
