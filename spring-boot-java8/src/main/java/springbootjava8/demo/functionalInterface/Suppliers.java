package springbootjava8.demo.functionalInterface;

import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * Suppliers 类 也是用来创建对象的，但不同于传统的new
 * 1.supplier是个接口，有一个get()方法
 * <p>
 * 2.语法 ：
 * <p>
 * Supplier<TestSupplier> sup= TestSupplier::new;
 * 3.每次调用get()方法时都会调用构造方法创建一个新对象。
 *
 * @author LiXiang
 * @date 2020/7/1 14:26
 */
@Component
public class Suppliers {

    private static final Long NUM = 100000L;

    public Supplier<String> suppliers(String msg) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "hi," + msg;
            }
        };
        return supplier;
    }

    /**
     * 惰性求值
     * <p>
     * 作用 ：我们可以把耗资源运算放到get方法里，在程序里，我们传递的是Supplier对象，
     * 直到调用get方法时，运算才会执行，这就是所谓的惰性求值
     *
     * @param number
     * @return
     */
    public Supplier<Double> supplier(Double number) {
        Supplier<Double> supplier = () -> {
            Double tmp = number;
            //模拟耗时操作
            for (int i = 0; i < NUM; i++) {
                tmp += Math.random();
            }
            return tmp;
        };
        return supplier;
    }

}
