package com.it.datastructure;

import com.it.data_structure.linkList.LinkedList;
import com.it.data_structure.List;

/**
 * 双向链表测试类
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> list=new LinkedList<>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(list.size(),40);
        // 移除1位置索引的元素
        list.remove(1);
        System.out.println(list);

    }
}
