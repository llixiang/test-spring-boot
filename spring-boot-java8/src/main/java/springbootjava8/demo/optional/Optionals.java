package springbootjava8.demo.optional;

import springbootjava8.demo.model.Goods;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author LiXiang
 * @date 2020/6/30 15:51
 */
public class Optionals {

    private static List<Goods> goodsList = new ArrayList<>();
    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    static {
        goodsList.add(new Goods(1L, "Padraig", 0, "接待员", 192.78, "透明", LocalDateTime.parse("2011-03-25 16:37:44", DateTimeFormatter.ofPattern(PATTERN)), LocalDateTime.parse("2019-10-05 15:16:39", DateTimeFormatter.ofPattern(PATTERN))));
        goodsList.add(new Goods(2L, "Geoffrey", 0, "接待员", 143.15, "天蓝色", LocalDateTime.parse("2015-05-14 22:23:27", DateTimeFormatter.ofPattern(PATTERN)), LocalDateTime.parse("2019-10-05 15:16:39", DateTimeFormatter.ofPattern(PATTERN))));
        goodsList.add(new Goods(3L, "Juan", 1, "研发工程师", 286.16, "天蓝色", LocalDateTime.parse("2007-11-06 13:06:44", DateTimeFormatter.ofPattern(PATTERN)), LocalDateTime.parse("2019-10-05 15:16:39", DateTimeFormatter.ofPattern(PATTERN))));
        goodsList.add(new Goods(4L, "Jean", 0, "行政经理", 89.25, "桔色", LocalDateTime.parse("2002-03-11 07:12:07", DateTimeFormatter.ofPattern(PATTERN)), LocalDateTime.parse("2019-10-05 15:16:39", DateTimeFormatter.ofPattern(PATTERN))));
        goodsList.add(new Goods(5L, "Anallese", 0, "网络运维工程师", 166.48, "酒红色", LocalDateTime.parse("2004-09-05 23:44:22", DateTimeFormatter.ofPattern(PATTERN)), LocalDateTime.parse("2019-10-05 15:16:39", DateTimeFormatter.ofPattern(PATTERN))));
        goodsList.add(new Goods(6L, "Roscoe", 0, "测试工程师", 30.39, "天蓝色", LocalDateTime.parse("2010-04-27 07:48:08", DateTimeFormatter.ofPattern(PATTERN)), LocalDateTime.parse("2019-10-05 15:16:39", DateTimeFormatter.ofPattern(PATTERN))));
        goodsList.add(new Goods(7L, "Alexandros", 0, "话务员", 107.38, "深灰色", LocalDateTime.parse("2012-07-15 05:46:04", DateTimeFormatter.ofPattern(PATTERN)), LocalDateTime.parse("2019-10-05 15:16:39", DateTimeFormatter.ofPattern(PATTERN))));
        goodsList.add(new Goods(8L, "Adair", 1, "研发工程师", 104.33, "黑色", LocalDateTime.parse("2009-12-18 17:53:51", DateTimeFormatter.ofPattern(PATTERN)), LocalDateTime.parse("2019-10-05 15:16:39", DateTimeFormatter.ofPattern(PATTERN))));
        goodsList.add(new Goods(9L, "Annnora", 1, "话务员", 196.45, "紫色", LocalDateTime.parse("2003-11-07 00:35:14", DateTimeFormatter.ofPattern(PATTERN)), LocalDateTime.parse("2019-10-05 15:16:39", DateTimeFormatter.ofPattern(PATTERN))));
    }

    /**
     * empty optional
     *
     * @return
     */
    public static Optional<Goods> empotyOptional() {
        Optional<Goods> optional = Optional.empty();
        return optional;
    }

    /**
     * list optional  of
     */
    public static Optional<List<Goods>> optionalOfList() {
        Optional<List<Goods>> optional = Optional.of(goodsList.stream().filter(m -> m.getColor()
                .equals("黑色")).collect(Collectors.toList()));
        return optional;
    }

    //可以使用of()和ofnullable()两个方法来创建包含值得Optional,两个方法的不同之处在于
    //如果把null值当作参数传入进去，of()方法会抛出NullPointerException
    //应该明确对象不为null得时候使用of() 如果对象可能是null也可能是非null，就应该使用ofNullable()方法

    //从optional实例中取回实际值对象得方法之一是使用get()方法。

    /**
     * list optional  ofNullable
     * Optional里面包裹的内容如果是集合要做特殊判断，不能直接optional.ispresent
     */
    public static Optional<List<Goods>> optionalOfNullableList() {
        Optional<List<Goods>> optional = Optional.ofNullable(goodsList.stream().filter(m -> m.getId()
                .equals(100)).collect(Collectors.toList()));
        return optional;
    }

    /**
     * Optional of Goods
     */
    public static Optional<Goods> optionalOfGoods() {
        Optional<Goods> optional = Optional.of(goodsList.get(2));
        return optional;
    }

    /**
     * Optional ofNullable Goods
     */
    //必须保证在使用Optional得包裹方法时，内部的表达式不会报错
    public static Optional<Goods> optionalOfNullableGoods() {
        Optional<Goods> optional = Optional.ofNullable(goodsList.get(2));
        return optional;
    }

    public static void main(String[] args) {
        optionalOfGoods();
        System.out.println("---------------------------");
        optionalOfList();
        System.out.println("---------------------------");
        optionalOfNullableGoods();
        System.out.println("---------------------------");
        optionalOfNullableList();
        System.out.println("---------------------------");
        empotyOptional();

    }
}



