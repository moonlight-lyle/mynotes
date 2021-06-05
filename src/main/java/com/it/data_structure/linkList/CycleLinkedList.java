package com.it.data_structure.linkList;

import com.it.data_structure.AbstractList;

/**
 * 自定义双向循环链表的实现
 * java官方是双向链表，但是没有循环
 * @author Lyle
 * @date 2021/5/22
 */
public class CycleLinkedList<E> extends AbstractList<E> {

    // 成员变量
    // 指向第一个节点
    private Node<E> first; // 指向第0个索引元素
    // 指向最后节点
    private Node<E> last;

    /**
     * 定义内部类，在LinkedList内部使用，一般用static修饰
     * 存储链表的元素
     *
     * @param <E>
     */
    private static class Node<E> {
        E element; // 元素，定义为泛型
        Node<E> next; // 指向下一个节点
        Node<E> prev; // 指向前一个节点

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }


    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        // 取出原来的元素
        Node<E> node = node(index);
        E old = node.element;
        // 覆盖原来的元素
        node.element = element;
        // 返回原来的元素
        return old;
    }

    @Override
    public void add(int index, E element) {
        // 索引检查
        rangeCheckForAdd(index);
        // 向尾部插入节点的情况，也就是说插入的节点就是之后的last，前一个节点是插入之前的last
        if (index == size) {
            //获取插入之前的last
            Node<E> oldLast = last;
            last = new Node<E>(element, oldLast, first);
            // 改变之前last的指向
            if (oldLast == null) {
                // 特殊情况：index==size==0,添加链表的第一个元素
                first = last;
                // 自己指向自己
                first.next=first;
                first.prev=first;
            } else {
                oldLast.next = last;
                first.prev=last;
            }
        } else {
            // 其他情况
            // 找到当前该索引位置的节点, 当前该位置的节点应是插入节点的下一个节点
            Node<E> next = node(index);
            // 插入节点的上一个节点应是当前索引位置节点的上一个节点
            Node<E> prev = next.prev;
            // 创建插入节点的对象
            Node<E> insertNode = new Node<>(element, prev, next);
            // 改变当前索引位置节点的指向：前一个节点应是插入的节点
            next.prev = insertNode;
            // 改变当前索引位置前一个节点的指向
            prev.next = insertNode;
            if (index==0){
                first = insertNode;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        // 索引判断
        rangeCheck(index);
        Node<E> node=first;
        if (size==1){
            first=null;
            last=null;
        }else {
            // 找到当前索引位置的节点
            node = node(index);
            // 改变当前索引位置节点前后节点的指向
            Node<E> prev = node.prev;
            Node<E> next = node.next;

            prev.next = next;
            next.prev = prev;
            if (index==0) {
                first = next;
            }
            if (index==size-1) {
                last = prev;
            }
        }
        // size-1
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            // 元素为null，返回第一个元素为null的索引
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            // 元素不为null
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置对应的节点
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        // 判断从前往后找还是从后往前找
        // 1.索引在前半部分
        if (index < (size >> 2)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            // 2. 索引在后半部分
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;

        }

    }

    /**
     * 重写toString()方法
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {

            sb.append(node.element);
            if (i != size - 1) {
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
