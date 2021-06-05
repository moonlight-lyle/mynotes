package com.it.datastructure;

import com.it.data_structure.linkList.SingleCycleLinkedList;
import com.it.data_structure.linkList.SingleLinkedList;
import com.it.data_structure.List;

/**
 * 单向链表测试类
 *
 * @author Lyle
 * @date 2021/5/24
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        List<Integer> list=new SingleCycleLinkedList<>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(list.size(),40);
        // 移除1位置索引的元素
        list.remove(1);
        System.out.println(list);

    }
}
