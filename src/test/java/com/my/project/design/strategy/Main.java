package com.my.project.design.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //int[] a = {9, 2, 4, 3, 5, 7, 1};
        Cat[] b = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        Dog[] c = {new Dog(3), new Dog(5), new Dog(1)};
        Sorter sorter = new Sorter();
        sorter.sort(b);
        System.out.println(Arrays.toString(b));
        sorter.sort(c);
        System.out.println(Arrays.toString(c));
    }
}
