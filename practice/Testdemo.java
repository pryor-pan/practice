package day02.com.genericity.practice;

/**
 * Remarks:
 * Author:panlai
 * :Date:2021/4/25
 */
class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
public class Testdemo {
    public static void main(String[] args) {
        A<String> a = new A("HAHAHA");

        String str = a.get();
        System.out.println(str);
    }

}
