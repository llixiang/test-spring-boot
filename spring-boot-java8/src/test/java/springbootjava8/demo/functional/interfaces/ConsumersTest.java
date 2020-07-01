package springbootjava8.demo.functional.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springbootjava8.demo.functionalInterface.Consumers;

import java.util.function.Consumer;

/**
 * @author LiXiang
 * @date 2020/7/1 11:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ConsumersTest {

    private Consumers consumers;

    @Before
    public void before() {
        consumers = new Consumers();
    }

    @Test
    public void consumers() {
        Consumer<String> consume = consumers.getConsume();
        consume.accept("A");
        consume.accept("B");

        // C 不会被输出，因为 adnThen 后面跟的是一个 Consumer，这个 Consumer 还没有 accpet 任何参数，所以虽然里面有打印语句，但是并不会被触发！
        consume.andThen(s -> {
            System.out.println("C");
        });

        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        stringConsumer.accept("D");

        consume.andThen(stringConsumer);

    }
}