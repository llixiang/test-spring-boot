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
public class IndexController4 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Redisson redisson;


    @RequestMapping("/deduct_stock4")
    public String deductStock() throws InterruptedException {
        String lockKey = "lockKey";  //k值
        //极端高并发情况下，会增大锁永久失效的情况，原因：自己线程加了锁，被其他的线程释放掉了
        try {
            //setnx(key,value)
            //加锁
//            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "lxx");
//           //设置超时时间
//            stringRedisTemplate.expire(lockKey,10, TimeUnit.SECONDS);

            //加锁和超时时间整成原子操作，可以替换上面注释掉的两个分开的操作
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "lxx", 10, TimeUnit.SECONDS);

            if (!result) {
                return "error";
            }

            //让其原子化执行  synchronized同步代码块
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
            stringRedisTemplate.delete(lockKey); //释放锁
        }


        return "end";

    }
}
