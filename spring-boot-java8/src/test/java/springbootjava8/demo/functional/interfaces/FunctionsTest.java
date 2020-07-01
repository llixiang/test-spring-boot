package springbootjava8.demo.functional.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springbootjava8.demo.functionalInterface.Functions;
import springbootjava8.demo.model.Goods;

import java.util.function.Function;

/**
 * @author LiXiang
 * @date 2020/7/1 10:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FunctionsTest {

    private Functions functions;


    @Before
    public void setUp() throws Exception {
        functions = new Functions();
    }

    @Test
    public void plusOneHundredFunction() {
        Long aLong = functions.plusOneHundredFunction(10L);
        log.info("==>:aLong" + aLong);

    }

    @Test
    public void behaviorParameterization() {
        functions.behavioralParameterization((Function<Goods, String>) goods -> goods.getName().toString());
    }

}
