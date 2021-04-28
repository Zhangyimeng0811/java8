package com.atguigu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("hello");

        System.out.println("hello");
        ArrayList<Object> objects = new ArrayList<>();
        for (Object object : objects) {

        }


    }


    @Test
    public void test() {

        Girl girl = new Girl();
        Optional<Girl> girlOptional = Optional.of(girl);
        System.out.println(girlOptional);

        girl = null;
        Optional<Girl> girlOptional1 = Optional.ofNullable(girl);
        System.out.println(girlOptional1);


    }

    public String getName(Boy boy) {

        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("haha")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("HAHA"));

        String name = girl1.getName();

        return name;
    }


    @Test
    public void test1() {

        Boy boy = new Boy();
        boy = null;
        System.out.println(getName(boy));


    }


}
