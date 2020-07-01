package springbootjava8.demo.functionalInterface;

import springbootjava8.demo.model.Goods;

import java.util.Comparator;

/**
 * Comparators 类
 *
 * @author LiXiang
 * @date 2020/6/30 17:24
 */
public class Comparators {

    /**
     * Comparator 比较器
     *
     * @return
     */
    public Comparator getIntCpmparator() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int cm = o1.compareTo(o2);
                return cm;
            }
        };
        return comparator;
    }

    /**
     * Comparator 比较器  多条件排序
     */
    public Comparator getGoodsComparator() {
        Comparator<Goods> comparator = new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                // 根据名称首字母 从 A -> Z、长度从小到大
                int r = 0;
                int cm = o1.getName().substring(0, 1).compareTo(o2.getName().substring(0, 1));
                if (cm != 0) {
                    // 比较几项这里最大数字就写几，然后呈梯次递减（即：3到1 -1到-3），这样代码比较容易阅读
                    r = cm > 0 ? 3 : -1;
                } else {
                    int len = o1.getName().length() - o2.getName().length();
                    if (len != 0) {
                        r = len > 0 ? 2 : -2;
                    } else {
                        int weight = (int) (o1.getWeight() - o2.getWeight());
                        if (weight != 0) {
                            r = weight > 0 ? 1 : -3;
                        }
                    }
                }

                return r;
            }
        };
        return comparator;
    }


}
