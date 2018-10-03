package com.normal.samples;

import java.util.function.Consumer;

/*
 * https://www.javabrahman.com/java-8/java-8-java-util-function-consumer-tutorial-with-examples/
 */
public class TestConsumer {
    public static void main(String[] args) {
        Consumer < String > consumer1 = (k) -> {System.out.println(k + "OK");};
        //consumer1.accept("TestConsumerAccept - ");
        Consumer < String > consumer2 = (x) -> {System.out.println(x + "OK!!!");};
        consumer1.andThen(consumer2).accept("TestConsumerAfterThen - ");
        //consumer1.accept("hello consumer 1 ");
        //consumer2.andThen(consumer1);
    }
}

