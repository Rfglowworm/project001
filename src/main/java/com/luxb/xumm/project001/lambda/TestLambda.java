package com.luxb.xumm.project001.lambda;

import com.luxb.xumm.project001.dto.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class TestLambda {
    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );


    @Test
    public void test1(){
        /**
         *匿名内部类
         */
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        Comparator<Integer> com2 = (x,y) -> Integer.compare(x,y);

    }

    @Test
    public void test2(){
        emps.stream().filter((e) -> e.getSalary()>5000).forEach(System.out::println);
        emps.stream().map((e) -> e.getName()).forEach(System.out::println);
    }

    /**
     * Java8内置的4大核心接口
     * 1.Consumer<T> 消费型接口
     *  void accept(T t);
     * 2.Supplier<T> 供给型接口
     *  T get();
     * 3.Function<T,R> 函数型接口
     *  R apply(T t);
     * 4.Predicate<T> 断言型接口
     *  boolean test(T t);
     */

    /**
     * 方法引用
     * 对象::实例方法名
     * 类::静态方法名
     * 类::实例方法名
     * 构造器引用
     * ClassName::new
     * 数据引用
     * Type[]::new
     */
    @Test
    public void test3(){
        Consumer<String> con = System.out::println;
        con.accept("aa");
        Employee emp = new Employee(101, "张三", 18, 9999.99);
        Supplier<String> sup = ()->emp.getName();
        System.out.println(sup.get());

        Supplier<Integer> sup1 = emp::getAge;
        System.out.println(sup1.get());

        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        System.out.println(com.compare(10,8));
        Comparator<Integer> com1 = Integer::compare;
        System.out.println(com.compare(8,10));

        BiPredicate<String,String> bp = String::equalsIgnoreCase;
        System.out.println(bp.test("aa","AA"));

        System.out.println("--------------------------");
        Supplier<Employee> sup2 = () -> new Employee();
        System.out.println(sup2.get());
        Supplier<Employee> sup3 = Employee::new;
        System.out.println(sup3.get());

        BiFunction<Integer,Integer,Employee> bf = Employee::new;
        System.out.println(bf.apply(10,11));

        Function<Integer,String[]> fun = (e) -> new String[e];
        String[] strs = fun.apply(10);
        Function<Integer,String[]> fun1 = String[]::new;
        String[] strs1 = fun1.apply(10);

    }

    @Test
    public void TestAaaa(){
        System.out.println("aaa");
        System.out.println("主干添加");
        System.out.println("分支添加");
        System.out.println("haha");
        System.out.println("在线添加");
    }

}
