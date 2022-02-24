package com.wangmou.x;

public class Dog<T> {
    T spec;

    public Dog(T t){
        this.spec = t;
    }
    public T getSpec() {
        return spec;
    }

    public void setSpec(T spec) {
        this.spec = spec;
    }
}
