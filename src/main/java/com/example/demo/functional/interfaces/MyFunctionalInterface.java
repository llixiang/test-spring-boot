package com.example.demo.functional.interfaces;

/**
 * 自定义一个 Functional Interfaces，接受一个 T 的参数，返回 R 类型数据
 * 使用上类似 {@link java.util.function.BiConsumer}，这里就不
 * +再介绍了
 *
 * @author LiXiang
 * @date 2020/6/1 17:47
 */
@FunctionalInterface
public interface MyFunctionalInterface<T, R> {
    /**
     * 接受一个T类型的参数的函数式接口
     *
     * @param t
     * @return
     */
    R apply(T t);
}
