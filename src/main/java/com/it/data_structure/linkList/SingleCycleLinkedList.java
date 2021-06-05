package com.it.data_structure.linkList;

import com.it.data_structure.AbstractList;

/**
 * 自定义单向循环链表的实现
 *
 * @author Lyle
 * @date 2021/5/22
 */
public class SingleCycleLinkedList<E> extends AbstractList<E> {

    // 成员变量
    private Node<E> first; // 指向第0个索引元素

    @Override
    public void clear() {
        size = 0;
        first = null;
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
        if (index == 0) {
            // 创建新的节点
            Node<E> newFirst = new Node<>(element, first);
            // 获取最后一个节点
            Node<E> last = (size == 0) ? newFirst : node(size-1);
            last.next = newFirst;
            first=newFirst;
        } else {
            // 其他情况
            // 获取当前节点的上一个节点
            Node<E> prev = node(index - 1);
            // 创建新节点并改变上一个节点和当前新加节点的指向
            prev.next = new Node<E>(element, prev.next);
        }
        // 创建完后size+1
        size++;
    }

    @Override
    public E remove(int index) {
        // 索引判断
        rangeCheck(index);
        // 取出被删除节点，设置默认值为first
        Node<E> node = first;
        if (index == 0) {
            if (size==1){
                first=null;
            }else {
                // 获取最后一个节点
                Node<E> last = node(size - 1);
                // 改变first的指向
                first = first.next;
                // 改变最后一个节点的指向
                last.next=first;
            }
        } else {
            // 获取当前节点的前一个元素
            Node<E> prev = node(index - 1);
            // 设置被删除的节点
            node = prev.next;
            // 改变前一个节点的指针指向为当前节点的next
            prev.next = node.next;
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
     * 定义内部类，在LinkedList内部使用，一般用static修饰
     * 存储链表的元素
     *
     * @param <E>
     */
    private static class Node<E> {
        E element; // 元素，定义为泛型
        Node<E> next; // 指向下一个节点

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 获取index位置对应的节点
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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
