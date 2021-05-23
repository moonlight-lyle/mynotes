package com.it.data_structure;

import com.it.algorithms.vo.Person;
import org.junit.Test;


/**
 * 动态数组的实现
 *
 * @author Lyle
 * @date 2021/5/16
 */
public class ArrayDemo {

//    @Test
//    public void test1()
    public static void main(String[] args)
    {

        int[] array=new int[]{11,22,33};

        // 使用自定义的动态数组，注意此处不是java集合中封装好的ArrayList，是自定义的
//        ArrayList<Integer> list=new ArrayList();
//        // list.get(-10);
//        list.add(11);
//        list.add(22);
//        list.add(33);
//        list.add(44);
//        list.add(55);
//        list.add(66);
//        System.out.println(list);
        // 测试移除元素
//        Integer old = list.remove(2);
//        System.out.println(old);
        // 测试添加元素
//        list.add(2,77);
//        System.out.println(list);
        // 测试扩容
//        for (int i = 0; i < 30; i++) {
//            list.add(i);
//        }

        // 测试泛型
        ArrayList<Person> list2 = new ArrayList<>();
        list2.add(new Person(18,"张三"));
        list2.add(null);
        list2.add(new Person(19,"李四"));
        list2.add(null);
        list2.add(new Person(20,"王五"));
        System.out.println(list2);
//        list2.clear();
//        // 提醒JVM进行垃圾回收
//        System.gc();

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("清理对象的内存地址");
    }
}
