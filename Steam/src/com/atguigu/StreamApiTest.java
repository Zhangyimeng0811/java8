package com.atguigu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiTest {


    //创建stream的方式 collection
    @Test
    public void test1(){

        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(1, "zs", 23, 234.5);
        Employee emp2 = new Employee(2, "ls", 24, 8500.5);
        Employee emp3 = new Employee(3, "ww", 11, 12537.4);
        Employee emp4 = new Employee(4, "xh", 27, 8500.5);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);

        Stream<Employee> stream = employees.stream();   //顺序流
        Stream<Employee> employeeStream = employees.parallelStream(); //并行流



    }



    //创建stream的方式 Arrays
    @Test
    public void test2(){

        int[] arr = new int[]{1,2,3,4,5,6};
        IntStream intStream = Arrays.stream(arr);


        Employee emp1 = new Employee(1, "zs", 23, 234.5);
        Employee emp2 = new Employee(2, "ls", 24, 8500.5);
        Employee emp3 = new Employee(3, "ww", 11, 12537.4);
        Employee emp4 = new Employee(4, "xh", 27, 8500.5);


        Employee[] employees = new Employee[]{emp1,emp2};
        Stream<Employee> employeeStream = Arrays.stream(employees);

    }


    //创建stream的方式 Stream 的of()
    @Test
    public void test3(){

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);

    }


    //创建stream的方式 Stream 无限流
    @Test
    public void test4(){

          Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);
          Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }


    //中间操作
    @Test
    public void test5(){

        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(1, "zs", 23, 234.5);
        Employee emp2 = new Employee(2, "ls", 24, 8500.5);
        Employee emp3 = new Employee(3, "ww", 11, 12537.4);
        Employee emp4 = new Employee(4, "xh", 27, 8500.5);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);

        Stream<Employee> stream = employees.stream();
        //过滤
        stream.filter(emp -> emp.getSalary()>7000).forEach(System.out::println);
        System.out.println("******");
        //筛选
        employees.stream().limit(2).forEach(System.out::println);
        System.out.println("******");
        //跳过
        employees.stream().skip(2).forEach(System.out::println);
        System.out.println("******");
        //去重
        employees.add(new Employee(1000,"刘强东",40,6000.0));
        employees.add(new Employee(1000,"刘强东",40,6000.0));
        employees.add(new Employee(1000,"刘强东",40,6000.0));
        employees.stream().distinct().forEach(System.out::println);
        System.out.println("******");
    }


    //中间操作 map 映射
    @Test
    public void test6(){

        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        System.out.println("******");


        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(1, "zs", 23, 234.5);
        Employee emp2 = new Employee(2, "ls", 24, 8500.5);
        Employee emp3 = new Employee(3, "ww", 11, 12537.4);
        Employee emp4 = new Employee(4, "xhs", 27, 8500.5);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        Stream<String> nameStream = employees.stream().map(employee -> employee.getName());
        nameStream.filter(s -> s.length()>2).forEach(System.out::println);


    }


    //中间操作 sort 排序
    @Test
    public void test7(){

        List<Integer> list = Arrays.asList(-5, 78, -54, 0, 23);
        list.stream().sorted().forEach(System.out::println);

        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(1, "zs", 23, 234.5);
        Employee emp2 = new Employee(2, "ls", 24, 8500.5);
        Employee emp3 = new Employee(3, "ww", 11, 12537.4);
        Employee emp4 = new Employee(4, "xhs", 27, 8500.5);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.stream().sorted((e1,e2)->Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);

    }


    //终止操作 查询
    @Test
    public void test8(){

        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(1, "zs", 23, 234.5);
        Employee emp2 = new Employee(2, "ls", 24, 8500.5);
        Employee emp3 = new Employee(3, "ww", 11, 12537.4);
        Employee emp4 = new Employee(4, "xhs", 27, 8500.5);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);

        boolean allMatch = employees.stream().allMatch(e -> e.getSalary() > 5000);
        System.out.println(allMatch);

        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 5000);
        System.out.println(anyMatch);

        boolean noneMatch = employees.stream().noneMatch(e -> e.getSalary() > 10000);
        System.out.println(noneMatch);

        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);


        long count = employees.stream().filter(e -> e.getSalary() > 8500).count();
        System.out.println(count);

        Optional<Employee> employee = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);

        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> min = doubleStream.min(Double::compare);
        System.out.println(min);
    }


    //终止操作 归约
    @Test
    public void test9(){

        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(1, "zs", 23, 234.5);
        Employee emp2 = new Employee(2, "ls", 24, 8500.5);
        Employee emp3 = new Employee(3, "ww", 11, 12537.4);
        Employee emp4 = new Employee(4, "xhs", 27, 8500.5);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);

        Optional<Double> sumSalary = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(sumSalary.orElse(5000.0));


    }

    //终止操作 收集
    @Test
    public void test10(){

        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(1, "zs", 23, 234.5);
        Employee emp2 = new Employee(2, "ls", 24, 8500.5);
        Employee emp3 = new Employee(3, "ww", 11, 12537.4);
        Employee emp4 = new Employee(4, "xhs", 27, 8500.5);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);

        List<Employee> list = employees.stream().filter(e -> e.getSalary() > 5000).collect(Collectors.toList());
        list.forEach(System.out::println);


    }







}
