package com.it.data_structure;

import java.util.Arrays;
import java.util.Objects;

/**
 * 自定义ArrayList的实现
 *
 * @author Lyle
 * @date 2021/5/16
 */

public class ArrayList<E> extends AbstractList<E>{

    // 存放元素的数组
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    // 构造函数, 默认数组长度是10
    public ArrayList() {
//        elements=new int[DEFAULT_CAPACITY];
        // 无参调用有参，通过this调用
        this(DEFAULT_CAPACITY);
    }

    // 构造函数，初始化数组长度
    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    /**
     * 清除元素的方法
     */
    public void clear() {
        // 清空数组中的存储元素（对象的内存地址）
        for (int i = 0; i < size; i++) {
            elements[i]=null;
        }
        size = 0;
    }

    /**
     * 获取指定索引处的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 给指定索引处设置指定的元素
     *
     * @param index：指定的索引
     * @param element：新值
     * @return: 返回索引处的旧值
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 向指定索引处添加指定的元素
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        // 判断元素是否为null
        if (element==null){
            return;
        }
        rangeCheckForAdd(index);
        // 扩容
        ensureCapacity(size+1);
        for (int i = size-1; i >= index; i--) {
            elements[i+1]=elements[i];
        }
        elements[index]=element;
        size++;
    }

    /**
     * 移除指定索引的元素
     *
     * @param index
     * @return 返回被删除的元素
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index+1; i < size; i++) {
            elements[i-1]=elements[i];
        }
        size--;
        // 清空原来最后一个位置存储的对象的内存地址
        elements[size]=null;
        return old;
    }

    /**
     * 返回指定元素在集合中的索引
     *
     * @param element
     * @return：
     */
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 重写toString()方法
     * @return
     */
    @Override
    public String toString() {
        // 在java中进行大量字符串拼接使用StringBuilder
        StringBuilder sb=new StringBuilder();
        sb.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i!=size-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 动态扩容的方法
     * @param capacity
     */
    private void ensureCapacity(int capacity){
        int oldCapacity=elements.length;
        // 判断目前数组的容量是否需要扩容
        if (oldCapacity>=capacity){
            return;
        }
        // 新数组的容量是旧容量的1.5倍
        int newCapacity = oldCapacity+(oldCapacity>>1);
        // 创建新数组
        E[] newElements= (E[]) new Object[newCapacity];
        // 将旧数组的元素拷贝到新数组
        for (int i = 0; i < size; i++) {
            newElements[i]=elements[i];
        }
        // 旧数组的引用指向新数组
        elements=newElements;
        System.out.println("扩容后的容量为："+newCapacity);
    }
}
