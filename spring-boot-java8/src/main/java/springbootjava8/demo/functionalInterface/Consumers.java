package springbootjava8.demo.functionalInterface;

import java.util.function.Consumer;

/**
 * Consumers 类
 *
 * @author LiXiang
 * @date 2020/6/30 17:58
 */
public class Consumers {
    /**
     * Consumer  表示对单个输入参数执行的操作。
     */
    public Consumer<String> getConsume() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        return consumer;
    }
}
