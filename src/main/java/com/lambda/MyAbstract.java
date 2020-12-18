package com.lambda;

abstract public class MyAbstract {

    private String greeting = "Hello";

    public String sayHello(String name) {
        return greeting + " " + name;
    }
}