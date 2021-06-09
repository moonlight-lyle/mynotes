package com.it.data_structure.queue;

import com.it.data_structure.List;
import com.it.data_structure.linkList.LinkedList;

import javax.swing.*;

/**
 * 自定义队列数据结构的实现
 * 因队列频繁在头尾进行添加删除操作，使用双向链表数据结构比较合适
 * java官方就是使用双向链表数据结构实现的
 */
public class Queue<E> {

    /**
     * 内部链表类
     */
    private List<E> list=new LinkedList<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * 向队列尾部添加元素
     * @param 
     */
    public void enQueue(E element){
        list.add(element);
    }

    /**
     * 移除队列头部的元素
     * @return
     */
    public E deQueue(){
        return list.remove(0);
    }

    /**
     * 获取队列头部的元素
     * @return
     */
    public E front(){
        return list.get(0);
    }
}
