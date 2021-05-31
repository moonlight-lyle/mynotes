package com.it.data_structure;

/**
 * 数据结构：栈的实现
 * 通过数组和链表都可以实现
 */
public class Stack<E> {

    /**
     * 通过ArrayList实现栈
     * 如果Stack直接继承ArrayList，会导致Stack多出很多不必要的接口
     */
    private List<E> list=new ArrayList<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * 向栈添加元素
     * @param element
     */
    public void push(E element){
        list.add(element);
    }

    /**
     * 移除栈顶的元素
     * @return
     */
    public E pop(){
        return list.remove(list.size()-1);
    }

    /**
     * 获取栈顶的元素
     * @return
     */
    public E top(){
        return list.get(list.size()-1);
    }

}
