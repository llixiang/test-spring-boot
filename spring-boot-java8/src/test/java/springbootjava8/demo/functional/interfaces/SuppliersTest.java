package springbootjava8.demo.functional.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springbootjava8.demo.functionalInterface.Suppliers;

import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

/**
 * @author LiXiang
 * @date 2020/7/1 14:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SuppliersTest {

    @Autowired
    private Suppliers suppliers;

    @Test
    public void suppliers() {
        Supplier<String> lx = suppliers.suppliers("lx");
        log.info("==>----------------" + lx.get());    //正确

        //  Expected :Hi,Good Dog
        //  Actual   :hi,lx
        assertEquals("Hi,Good Dog", lx.get());   //错误
    }

    @Test
    public void supplier() {
        Supplier<Double> suppliers = this.suppliers.supplier(20.01D);
        System.out.println(suppliers.get());
    }


}
