package com.my.project.design.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //int[] a = {9, 2, 4, 3, 5, 7, 1};
        Cat[] b = {new Cat(3, 5), new Cat(5, 1), new Cat(1, 3)};
        Dog[] c = {new Dog(3), new Dog(5), new Dog(1)};
        Sorter sorter = new Sorter();
        sorter.sort(b);
        System.out.println(Arrays.toString(b));
        sorter.sort(b, ((c1, c2) -> c2.height - c1.height));
        System.out.println(Arrays.toString(b));
        sorter.sort(c);
        System.out.println(Arrays.toString(c));
    }
}
