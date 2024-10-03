package com.dz2;

import com.dz2.util.ArraysList;
import com.dz2.util.MyCollections;

public class ArraysListDemo {
    public static void main(String[] args){
        ArraysList<Double> list = new ArraysList<>(1000);

        Employee employee = new Employee("Zhak", 39);
        Employee employee2 = new Employee("Yak", 20);
        Employee employee3 = new Employee("Abdad", 10);

        ArraysList<Employee> employees = new ArraysList<>();
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);


        MyCollections.sort(employees, new MyComparator());
        System.out.println(employees.isSorted(new MyComparator()));


        for(int i = 0; i<1000; i++){
            list.add(Math.random());
        }
        MyCollections.sort(list);
        System.out.println();
        System.out.println(list.isSorted());

    }
}
