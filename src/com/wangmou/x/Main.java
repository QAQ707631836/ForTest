package com.wangmou.x;

public class Main {
    public static<T> void showKeyValue(Dog<T> obj){
        System.out.println("泛型测试,key value is " + obj.getSpec());
    }

    public static void main(String[] args) {
        Dog<Integer> gInteger = new Dog<Integer>(123);
        Dog<Number> gNumber = new Dog<Number>(456);

        showKeyValue(gInteger);
        showKeyValue(gNumber);

    }
}
