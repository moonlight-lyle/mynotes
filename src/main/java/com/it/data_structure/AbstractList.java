package com.it.data_structure;

/**
 * 抽象类，用于抽取子类之间的公共代码用以复用
 *
 * @author Lyle
 * @date 2021/5/23
 */
public abstract class AbstractList<E> implements List<E>{

    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element)!=ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size,element);
    }

    /**
     * 抽出索引校验
     * @param index
     */
    protected void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    protected void rangeCheck(int index){
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index){
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}
