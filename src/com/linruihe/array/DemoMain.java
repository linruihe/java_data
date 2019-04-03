package com.linruihe.array;

import com.linruihe.common.array.GenericArray;

public class DemoMain {

    public static void main(String[] args) {
        GenericArray array = new GenericArray(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.addFirst(100);
        array.add(5,55);
        array.remove(1);
        System.out.println(array.toString());
        System.out.println(array.findIndex(100));
        array.set(5,88);
        System.out.println(array.toString());
    }
}
