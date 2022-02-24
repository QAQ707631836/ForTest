package QAQ2;

import java.util.Arrays;
import java.util.List;

class Foo {
    protected int id;
}

class Child extends Foo {
    void s() {
        System.out.println(id);
    }
}
class Main{
//    public static void main(String[] args) {
//        Child child = new Child();
//        child.s();
//    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 4);
        Integer[] array = integers.toArray(new Integer[]{});
        for (Integer integer : array) {
            System.out.println(integer);
        }
    }
}