package com.it.algorithms.vo;

/**
 * 抽象数据类型：计数器
 *
 * @author Lyle
 * @date 2021/5/8
 */
public class Counter {

    private final String name;

    private int count;

    public Counter(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return count+" "+name;
    }

    /**
     * 模拟计数器计数
     */
    public void increment(){
        count++;
    }

    /**
     * 返回统计的count
     * @return
     */
    public int tally(){
        return count;
    }
}
