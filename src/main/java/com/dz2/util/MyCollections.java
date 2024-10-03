package com.dz2.util;

import java.util.Comparator;
import java.util.List;

public class MyCollections {

    private MyCollections(){
    }

    public  static <E> void sort(List<E> list){
        list.sort(null);
    }

    public static <E> void sort(List<E> list, Comparator<? super E> c){
        list.sort(c);
    }
}
