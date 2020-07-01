package springbootjava8.demo.functional.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springbootjava8.demo.functionalInterface.Predicates;

/**
 * @author LiXiang
 * @date 2020/7/1 13:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PredicatesTest {

    @Autowired
    private Predicates predicates;


    @Test
    public void jundgeNumberOne() {
        boolean a = predicates.judgeNumberOne(10);
        log.info("==>------Boolean-----" + a);
        boolean b = predicates.judgeNumberOne(1000);
        log.info("==>------Boolean-----" + b);
    }

    @Test
    public void judgeNumberTwo() {
        boolean a = predicates.judgeNumberTwo(10);
        log.info("==>------Boolean-----" + a);
        boolean b = predicates.judgeNumberTwo(1000);
        log.info("==>------Boolean-----" + b);
    }

    @Test
    public void judgeNumberNegate() {
        boolean a = predicates.judgeNumberNegate(10);
        log.info("==>------Boolean-----" + a);
        boolean b = predicates.judgeNumberNegate(1000);
        log.info("==>------Boolean-----" + b);
    }
}
