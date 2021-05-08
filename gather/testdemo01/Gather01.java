package day01.com.gather.testdemo01;

import java.sql.Connection;
import java.util.*;

/**
 * Remarks: 集合框架和背后的数据结构
 *              每一个集合的背后都是一种数据结构
 *              接口主要是功能的一个抽象。
 *              PriorityQueue:优先级队列，完全二叉树
 *              TreeSet:的底层是一颗二叉树
 *              HashSet：的底层是哈希表.
 *          Map接口 HashMap和TreeMap 不能通过迭代器遍历
 *          迭代器；遍历集合的
 *
 *
 * Author:panlai
 * :Date:2021/4/24
 */
public class Gather01 {

    public static void main(String[] args) {
        Collection<String> col = new ArrayList<>();     //<String>泛型
        col.add("hello");
        //col.add(10);      //不能放，因为前面泛型标记了类型必须为string
        col.add("java");
        col.add("hello");
        System.out.println(col);
        col.remove("java");
        System.out.println(col);
        col.clear();
        System.out.println(col);
        //一般不会用collection，因为太大了，都是具体的类

        //map存放元素的时候，不一定会根据你存放的顺序打印出你存的内容。
        Map<String,String> map = new HashMap<>();
        map.put("及时雨","宋江");
        map.put("国民老公","王思聪");
        map.put("沙僧","沙悟净");
        System.out.println(map);    //打印的顺序不是添加的顺序，具体为什么，后面hashmap将。
        System.out.println(map.get("及时雨"));
        System.out.println(map.get("唐僧"));
        System.out.println(map.getOrDefault("唐僧","悟空"));

        Set<Map.Entry<String,String>> set = map.entrySet();     //打包成新的数据结构
        for (Map.Entry<String,String> entry:set) {
            String key = entry.getKey();
            String val = entry.getValue();
            System.out.println(key + " + " + val);
        }

    }
}
