package com.example.demo;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    @Value("${spring.redis.host:localhost}")
    private String host;

    @Value("${spring.redis.port:6379}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    //创建redisson客户端
//    @Bean
//    public Redisson redisson(){
//        //此为单机模式
//        Config config=new Config() ;
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
//        return (Redisson) Redisson.create(config);
//    }

    /**
     * 单机 redisson 配置
     *
     * @return
     */
    @Bean
    public RedissonClient single() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + host + ":" + port)
                .setPassword(null)
                .setDatabase(0)
                .setConnectionPoolSize(64)
                .setConnectionMinimumIdleSize(32);
        config.setThreads(0);
        config.setNettyThreads(0);
        config.setCodec(new JsonJacksonCodec());
        config.setTransportMode(TransportMode.NIO);
        return Redisson.create(config);
    }

}
