package com.morton.algorithm.system.class03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * 哈希表和有序表
 *
 * @author MortonShaw
 * @date 2021/10/10 21:47
 */
public class Code09_HashMapAndSortedMap {

    public static class Node {
        public int value;

        public Node(int v) {
            value = v;
        }
    }

    public static class Zuo {
        public int value;

        public Zuo(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, String> test = new HashMap<>();
        Integer a = 19000000;
        Integer b = 19000000;
        // 比较内存地址
        System.out.println(a == b);
        System.out.println(a.equals(b));
        test.put(a, "一个整形数字");
        // 按值传递，比较值
        System.out.println(test.containsKey(b));
        System.out.println("--------------Integer--------------");

        HashMap<String, String> test2 = new HashMap<>();
        String a2 = "19000000";
        String b2 = "19000000";
        // 比较内存地址
        System.out.println(a2 == b2);
        System.out.println(a2.equals(b2));
        test2.put(a2, "一个整形数字");
        // 按值传递，比较值
        System.out.println(test2.containsKey(b2));
        System.out.println("--------------String--------------");

        HashMap<String, String> test3 = new HashMap<>();
        String a3 = new String("19000000");
        String b3 = new String("19000000");
        // 比较内存地址
        System.out.println(a3 == b3);
        System.out.println(a3.equals(b3));
        test3.put(a3, "一个整形数字");
        // 按值传递，比较值
        System.out.println(test3.containsKey(b3));
        System.out.println("--------------New String--------------");

        // UnSortedMap
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1000000, "我是1000000");
        map.put(2, "我是2");
        map.put(3, "我是3");
        map.put(4, "我是4");
        map.put(5, "我是5");
        map.put(6, "我是6");
        map.put(1000000, "我是1000001");

        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(10));

        System.out.println(map.get(4));
        System.out.println(map.get(10));

        map.put(4, "他是4");
        System.out.println(map.get(4));

        map.remove(4);
        System.out.println(map.get(4));

        // key
        HashSet<String> set = new HashSet<>();
        set.add("abc");
        set.contains("abc");
        set.remove("abc");

        // 哈希表，增、删、改、查，在使用时，O（1）

        System.out.println("=====================");

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);

        Integer e = 127; // - 128 ~ 127
        Integer f = 127;
        System.out.println(e == f);

        System.out.println("=====================");

        HashMap<Node, String> map2 = new HashMap<>();
        Node node1 = new Node(1);
        Node node2 = node1;
        map2.put(node1, "我是node1");
        map2.put(node2, "我是node2");
        System.out.println(map2.size());
        System.out.println(map2);
        System.out.println("======================");

        // TreeMap 有序表：接口名
        // 红黑树、avl、sb树、跳表
        // O(logN)
        System.out.println("有序表测试开始");
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(3, "我是3");
        treeMap.put(4, "我是4");
        treeMap.put(8, "我是8");
        treeMap.put(5, "我是5");
        treeMap.put(7, "我是7");
        treeMap.put(1, "我是1");
        treeMap.put(2, "我是2");

        System.out.println(treeMap.containsKey(1));
        System.out.println(treeMap.containsKey(10));

        System.out.println(treeMap.get(4));
        System.out.println(treeMap.get(10));

        treeMap.put(4, "他是4");
        System.out.println(treeMap.get(4));

        treeMap.remove(4);
        System.out.println(treeMap.get(4));

        System.out.println("新鲜：");
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());
        // <= 6
        System.out.println(treeMap.floorKey(6));
        // >= 6
        System.out.println(treeMap.ceilingKey(6));
    }

}
