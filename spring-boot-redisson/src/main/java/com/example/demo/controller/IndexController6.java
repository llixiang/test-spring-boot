package com.example.demo.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 解决超时问题，不同线程所需时间不同，（引入了）用到了redisson分布式锁
 * <p>
 * 三行代码：
 * RLock lock = redisson.getLock(lockKey); 获取锁
 * lock.tryLock(30, TimeUnit.SECONDS); 加锁时间
 * lock.unlock(); 释放锁
 * </p>
 *
 * @author LiXiang
 * @date 2020/6/3 10:13
 */
@RestController
@RequestMapping
public class IndexController6 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Redisson redisson;


    @RequestMapping("/deduct_stock6")
    public String deductStock() throws InterruptedException {
        String lockKey = "lockKey";  //k值
        //给每个线程生成一个唯一的clinteId,用UUID去生成
        //  String clintId = UUID.randomUUID().toString();
        RLock lock = redisson.getLock(lockKey);


        //解决锁永久失效的情况
        try {
            //setnx(key,value)
            //加锁
//            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "lxx");
//           //设置超时时间
//            stringRedisTemplate.expire(lockKey,10, TimeUnit.SECONDS);
            //加锁和超时时间整成原子操作，可以替换上面注释掉的两个分开的操作

//            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clintId, 10, TimeUnit.SECONDS);
//
//            if (!result) {
//                return "error";
//            }

            lock.tryLock(30, TimeUnit.SECONDS);
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
            lock.unlock();
            //释放锁时去判断
//            if (clintId.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
//                stringRedisTemplate.delete(lockKey); //释放锁
//            }
        }
        return "end";
    }
}