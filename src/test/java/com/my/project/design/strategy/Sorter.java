package com.my.project.design.strategy;

import java.util.Comparator;

public class Sorter {
    public <T extends Comparable<T>> void sort(T[] a) {
        sort(a, null);
    }

    public <T extends Comparable<T>> void sort(T[] a, Comparator<T> comparator) {
        if (comparator == null) {
            comparator = Comparable::compareTo;
        }
        for(int i=0; i<a.length-1; i++) {
            int minPos = i;
            for(int j=i+1; j<a.length; j++) {
                minPos = comparator.compare(a[j], a[minPos]) < 0 ? j : minPos;
            }
            // swap
            T temp = a[i];
            a[i] = a[minPos];
            a[minPos] = temp;
        }
    }
}
