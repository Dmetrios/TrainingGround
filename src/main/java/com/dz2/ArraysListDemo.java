package com.dz2;

import com.dz2.util.ArraysList;
import com.dz2.util.MyCollections;

import java.util.List;

public class ArraysListDemo {
    public static void main(String[] args){
        ArraysList<Double> list = new ArraysList<>(100000);

        Employee employee = new Employee("Zhak", 39);
        Employee employee2 = new Employee("Yak", 20);
        Employee employee3 = new Employee("Abdad", 10);
        Employee employee4 = new Employee("Beer", 10);
        Employee employee5 = new Employee("Derbu", 10);
        Employee employee6 = new Employee("Asas", 10);
        Employee employee7 = new Employee("Efd", 10);
        Employee employee8 = new Employee("Qad", 10);
        Employee employee9 = new Employee("Idad", 10);
        Employee employee10 = new Employee("OIbdad", 10);

        List<Employee> employees = new ArraysList<>();
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
        employees.add(employee9);
        employees.add(employee10);


        MyCollections.sort(employees, new MyComparator());
//        System.out.println(employees.isSorted(new MyComparator()));


        for(int i = 0; i<1000; i++){
            list.add(Math.random());
        }
        MyCollections.sort(list);
        System.out.println();
        System.out.println(list.isSorted());

    }
}
