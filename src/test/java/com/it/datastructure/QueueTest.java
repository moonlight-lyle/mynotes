package com.it.datastructure;

import com.it.data_structure.queue.Queue;

/**
 * 队列的测试
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue=new Queue<>();
        queue.enQueue(11);
        queue.enQueue(22);
        queue.enQueue(33);
        queue.enQueue(44);
        queue.deQueue();
        while (!queue.isEmpty()){
            System.out.println(queue.deQueue());
        }
    }
}
