package com.interfacetest.useinterfase02;

import java.util.Comparator;

/**
 * Remarks:
 * Author:panlai
 * :Date:2021/4/21
 */
public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}
