package com.it.data_structure;

/**
 * 自定义ArrayList的实现
 *
 * @author Lyle
 * @date 2021/5/16
 */
public class ArrayList {

    //成员变量:数组的大小
    private int size;
    // 存放元素的数组
    private int[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    // 构造函数, 默认数组长度是10
    public ArrayList() {
//        elements=new int[DEFAULT_CAPACITY];
        // 无参调用有参
        this(DEFAULT_CAPACITY);
    }

    // 构造函数，初始化数组长度
    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = new int[capacity];
    }

    /**
     * 清除元素的方法
     */
    public void clear() {
        size=0;
    }

    /**
     * 集合的容量
     */
    public int size() {
        return size;
    }

    /**
     * 判断集合是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断集合是否包含某个元素
     *
     * @param element
     * @return
     */
    public boolean contains(Integer element) {
        if (indexOf(element) != ELEMENT_NOT_FOUND) {
            return true;
        }
        return false;
    }

    /**
     * 向集合中添加元素
     *
     * @param element
     */
    public void add(Integer element) {

    }

    /**
     * 获取指定索引处的元素
     *
     * @param index
     * @return
     */
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组索引越界异常！");
        }
        return elements[index];
    }

    /**
     * 给指定索引处设置指定的元素
     *
     * @param index：指定的索引
     * @param element：新值
     * @return: 返回索引处的旧值
     */
    public Integer set(int index, Integer element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组索引越界异常！");
        }
        int old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 向指定索引处添加指定的元素
     *
     * @param index
     * @param element
     */
    public void add(int index, Integer element) {

    }

    /**
     * 移除指定索引的元素
     *
     * @param index
     * @return 返回被删除的元素
     */
    public Integer remove(int index) {
        return 0;
    }

    /**
     * 返回指定元素在集合中的索引
     *
     * @param element
     * @return：
     */
    public int indexOf(Integer element) {
        for (int i = 0; i < size; i++) {
            if (element == elements[i]) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


}
