package com.my.project.design.strategy;

public class Sorter {
    public <T extends Comparable<T>> void sort(T[] a) {
        for(int i=0; i<a.length-1; i++) {
            int minPos = i;
            for(int j=i+1; j<a.length; j++) {
                minPos = a[j].compareTo(a[minPos]) < 0 ? j : minPos;
            }
            // swap
            T temp = a[i];
            a[i] = a[minPos];
            a[minPos] = temp;
        }
    }
}
