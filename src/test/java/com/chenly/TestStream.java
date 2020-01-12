package com.chenly;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author luwt
 * @date 2019/12/5.
 */
public class TestStream {

    /**
     * 流共分为三大部分：
     *  1、打开流
     *  2、对流的具体操作
     *  3、终止操作
     *  流是惰性操作，只有在遇到终止操作才会计算出结果，否则都只是一个过程状态。
     *  所以想要获取结果，必须要有终止操作；对流的中间操作都会的到一个过程状态，
     *  这个过程状态是可以继续传递给下个流进行操作的。
     *  需要注意的是，流是不可逆的操作，一次消费结束后（终止操作后），本次的流就结束了。
     *  不可以在终止操作之后再对流进行任何操作。
     */


    /**
     * 需要注意的是打开流之前最好能确定集合或数组非空，如果是空会抛空指针异常
     * @param type
     * @return
     */
    private static Stream openStream(String type){
        // 数组打开方式
        Integer[] array = new Integer[]{1, 3, 1, 2, 5, 2, 6, 4};
        Stream<Integer> arrayStream = Arrays.stream(array);
        // 集合打开方式，即：Collection.stream()
        List<String> list = new ArrayList<String>(){{add("a"); add("b"); add("c");}};
        Stream<String> listStream = list.stream();
        return type.equals("array") ? arrayStream : listStream;
    }

    /**
     * 对流的操作（常用的）：
     * filter：过滤，从流中筛选出符合条件（断言）的元素；
     * map：映射，将流中的每一个元素都执行一个操作，即将某个操作映射到每个元素上；
     * flatmap：扁平化操作，可以将二维数组合并为一个一维数组；
     * distinct：对流中元素去重；
     * limit：取前多少元素；
     * skip：跳过多少元素；
     * sorted：排序，可以自定义。
     * 其他的像 mapToInt等，都是对上面操作的一个增进。
     * @param stream
     * @return
     */
    private static Stream operateStream(Stream<Integer> stream, String type){
        if (type.equals("filter")) {
            // filter，传入一个断言，或者一个条件，符合的元素将被筛出来
            // out -> [5 6 4]
            stream = stream.filter(a -> a > 3);
        } else if (type.equals("map")) {
            // map，对每个元素都执行指定操作
            // out -> [1 9 1 4 25 4 36 16]
            stream = stream.map(a -> a * a);
        } else if (type.equals("flatmap")){
            // flatmap，将多个小的流合并为一个大的流，即扁平化，创建一个二维数组，扁平化将会把其变为一个一维数组。
            // out -> [10 11 12 13 14 15]
            Integer[] a = new Integer[]{10, 11, 12};
            Integer[] b = new Integer[]{13, 14, 15};
            // 下面两种写法是一样的，c1 与 listStream相同
            List<Integer[]> c = new ArrayList<Integer[]>(){{add(a); add(b);}};
            Stream<List<Integer[]>> c1 = Stream.of(c);

            Stream<List<Integer>> listStream = Stream.of(Arrays.asList(a), Arrays.asList(b));
            return listStream.flatMap(Collection::stream);
        } else if (type.equals("distinct")){
            // distinct 去重操作
            // out -> [1 3 2 5 6 4]
            stream = stream.distinct();
        } else if (type.equals("limit")){
            // limit 取前多少个元素
            // out -> [1 3 1]
            stream = stream.limit(3);
        } else if (type.equals("skip")){
            // skip 跳过前多少个元素
            // out -> [1 2 5 2 6 4]
            stream = stream.skip(2);
        } else if (type.equals("sorted")) {
            // sorted 排序
            // out -> [1 1 2 2 3 4 5 6]
            stream = stream.sorted();
            // 自定义排序，将小于5的值都放到前面
            // out -> [4 2 2 1 3 1 5 6]，顺序是按-1， 0， 1来排的
            stream = stream.sorted((x, y) -> {
                if (x < 5) {
                    return -1;
                } else if (x.equals(y)){
                    return 0;
                } else {
                    return 1;
                }
            });
            // 也可以这样写，与第一种写法类似，接收一个comparator
            // out -> [1 1 2 2 3 4 5 6]
            stream = stream.sorted(Comparator.comparing(Integer::intValue));
        }
        return stream;
    }

    /**
     * 终止流的操作（消费）：
     * reduce：将流内的元素进行聚合操作，譬如做算术运算，其结果为一个Optional容器；
     * foreach：将流内的元素消费掉，接收一个函数用以消费流；
     * collect：将流内的元素收集起来；
     * count：统计流内元素个数；
     * findAny: 从流内元素随机返回一个值，放入Optional容器；
     * findFirst：将流内元素的第一个值取出，放入Optional容器；
     * max、min：求流内元素的最大或最小值，放入Optional容器；
     * toArray：将流内元素转为一个数组；
     * allMatch：接收一个断言（一个匹配条件），判断元素是否全部匹配，返回布尔值；
     * anyMatch：接收一个断言（一个匹配条件），判断是否存在匹配的元素，返回布尔值；
     * noneMatch：接收一个断言（一个匹配条件），判断是否全部不匹配，返回布尔值。
     * ！！！需要注意的是，终止操作只能执行一次，消费一次流就没有了，就不能再消费了！！！
     * @param stream
     * @return
     */
    private static void terminalStream(Stream<Integer> stream, String operation){
        if (operation.equals("reduce")){
            Optional<Integer> reduce;
//            reduce = stream.reduce((x, y) -> x + y);
            // 等同于下面的写法，reduce将会产生一个Optional容器对象，
            // 该容器只能存一个值，或者没有。
            // Optional容器取值用get方法，判断是否有值用isPresent方法
            // out -> [24]
            reduce = stream.reduce(Integer::sum);
            if (reduce.isPresent())
                System.out.println(reduce.get());
        } else if (operation.equals("foreach")){
            // 消费流，接收一个函数，没有返回值
            // out -> [1 3 1 2 5 2 6 4]
            stream.forEach(System.out::println);
        } else if (operation.equals("collect")){
            // 将流中的元素收集起来：
            // 收集为 list
            // out -> [1, 3, 1, 2, 5, 2, 6, 4]
//            List<Integer> list = stream.collect(Collectors.toList());
//            System.out.println(list);
            // 收集为 set
            // out -> [1, 2, 3, 4, 5, 6]
//            Set<Integer> set = stream.collect(Collectors.toSet());
//            System.out.println(set);
            // 收集为 map，由于我这里举例的是一个纯数字的数组，所以收集为map的时候没有办法指定元素的某个属性，
            // 就直接将该元素设为key和value，Function.identity()指向元素本身，也可以用lambda表达式 x-> x，
            // 如果是实际业务，流中的元素为一个实体类，那么久可以用 x -> x.getProperty()，指定属性了。
            // 尤其需要注意的是：map是不允许键重复的，，所以在键如果会重复的情况下，需要指定一个合并冲突的方法，
            // 这里用第二个键覆盖第一个。
            // out -> {1=1, 2=2, 3=3, 4=4, 5=5, 6=6}
            Map<Integer, Integer> map = stream.collect(Collectors.toMap(Function.identity(), x -> x, (v1, v2) -> v2));
            System.out.println(map);
        } else if (operation.equals("count")) {
            // 统计元素个数
            // out -> [8]
            long count = stream.count();
            System.out.println(count);
        } else if (operation.equals("findAny")){
            // 随机返回一个值
            // out -> [1]
            Optional<Integer> any = stream.findAny();
            any.ifPresent(System.out::println);
        } else if (operation.equals("findFirst")){
            // 返回第一个值
            // out -> [1]
            Optional<Integer> first = stream.findFirst();
            first.ifPresent(System.out::println);
        } else if (operation.equals("max|min")){
            // 返回最大值
            // out -> [6]
//            Optional<Integer> max = stream.max(Integer::compareTo);
//            max.ifPresent(System.out::println);
            // 返回最小值
            // out -> [1]
            Optional<Integer> min = stream.min(Integer::compareTo);
            min.ifPresent(System.out::println);
        } else if (operation.equals("toArray")){
            // 转为数组
            // out -> [1, 3, 1, 2, 5, 2, 6, 4]
            Object[] array = stream.toArray();
            System.out.println(Arrays.toString(array));
        } else if (operation.equals("allMatch")){
            // 全匹配
            // out -> true
            boolean allMatch = stream.allMatch(x -> x.compareTo(0) > 0);
            System.out.println(allMatch);
        } else if (operation.equals("anyMatch")){
            // 只要匹配一个即可
            // out -> true
            boolean anyMatch = stream.anyMatch(x -> x.compareTo(5) > 0);
            System.out.println(anyMatch);
        } else if (operation.equals("noneMatch")){
            // 都不匹配的情况
            // out -> true
            boolean noneMatch = stream.noneMatch(x -> x.compareTo(0) < 0);
            System.out.println(noneMatch);
        }
    }

    public static void main(String[] args) {
        Stream stream = openStream("array");
//        operateStream(stream, "sorted").forEach(s -> System.out.printf("%d ", s));
        terminalStream(stream, "noneMatch");
    }
}
