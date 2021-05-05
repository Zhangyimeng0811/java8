package com.atguigu;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest {

    @Test
    public void test1(){

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        r1.run();

        System.out.println("******");
        Runnable r2 = () -> System.out.println("haha");
        r2.run();
        System.out.println("******");
        PrintStream ps = System.out;
        Runnable r3 = ps :: println;
        r3.run();


    }



    @Test
    public void test2(){

        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int result = comparator1.compare(12, 21);
        System.out.println(result);
        System.out.println("*********");

        Comparator<Integer> comparator2 =  (o1,o2) -> Integer.compare(o1,o2);
        int result2 = comparator2.compare(112, 21);
        System.out.println(result2);

        System.out.println("*********");

        Comparator<Integer> comparator3 =  Integer::compare;
        int result3 = comparator3.compare(10, 21);
        System.out.println(result3);

    }


    @Test
    public void test3(){

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("hahaha");

        System.out.println("****");

        Consumer<String> consumer1 = s -> System.out.println(s);
        consumer1.accept("hehe");

        System.out.println("***");
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("hehhehe");


    }

}
