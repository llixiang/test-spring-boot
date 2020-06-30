package springbootelasticsearch.demo.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springbootelasticsearch.demo.Model.User;
import springbootelasticsearch.demo.service.UserService;

/**
 * @author LiXiang
 * @date 2020/6/30 11:31
 * Spring boot的CommandLineRunner接口主要用于实现在应用初始化后，去执行一段代码块逻辑，这段初始化代码在整个应用生命周期内只会执行一次。
 */
@Component
@Slf4j
/**
 * Spring boot的CommandLineRunner接口主要用于实现在应用初始化后，
 * 去执行一段代码块逻辑，这段初始化代码在整个应用生命周期内只会执行一次。
 */
public class EsRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        log.info("==>  ES demo is start running...");

        User user = User.builder().id(System.currentTimeMillis())
                .age(23)
                .name("LX")
                .remark("I am lx")
                .build();

        log.info("==> ready to save user:{}", user);

        userService.saveUser(user);

        log.info("==> user has been saved:{}", user);

        log.info("==> find all userList:{}", userService.findAll());
    }
}
