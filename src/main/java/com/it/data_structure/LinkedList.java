package com.it.data_structure;

/**
 * 自定义链表的实现
 *
 * @author Lyle
 * @date 2021/5/22
 */
public class LinkedList<E> extends AbstractList<E>{

    // 成员变量
    private Node<E> first; // 指向第0个索引元素

    @Override
    public void clear() {
        size=0;
        first=null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        // 取出原来的元素
        Node<E> node=node(index);
        E old=node.element;
        // 覆盖原来的元素
        node.element=element;
        // 返回原来的元素
        return old;
    }

    @Override
    public void add(int index, E element) {
        // 0是特殊位置，需要特殊处理
        if (index==0){
            first=new Node<E>(element,first);
        }else {
            // 获取当前节点的上一个节点
            Node<E> prev=node(index-1);
            // 创建新节点并改变上一个节点和当前新加节点的指向
            prev.next=new Node<E>(element,prev.next);
        }
        // 创建完后size+1
        size++;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    /**
     * 定义内部类，在LinkedList内部使用，一般用static修饰
     * 存储链表的元素
     * @param <E>
     */
    private static class Node<E>{
        E element; // 元素，定义为泛型
        Node<E> next; // 指向下一个节点

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 获取index位置对应的节点
     * @param index
     * @return
     */
    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> node=first;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }
}
