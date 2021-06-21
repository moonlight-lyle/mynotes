package com.it.datastructure;

import com.it.data_structure.printer.BinaryTrees;
import com.it.data_structure.tree.BinarySearchTree;
import com.it.pojo.Person;
import com.it.util.Files;

import java.util.Comparator;

public class BinarySearchTreeTest {

//    public static class PersonComparator<P> implements Comparator<Person> {
//
//        @Override
//        public int compare(Person e1, Person e2) {
//            return e1.getAge() - e2.getAge();
//        }
//    }
//
//    public static class PersonComparator2<P> implements Comparator<Person> {
//
//        @Override
//        public int compare(Person e1, Person e2) {
//            return e2.getAge() - e1.getAge();
//        }
//    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };
//        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        // 打印普通类型数组
//        for (int i = 0; i < data.length; i++) {
//            bst.add(data[i]);
//        }
//        // 打印
//        BinaryTrees.println(bst);

        //自定义数组的打印
//        BinarySearchTree<Person> bst = new BinarySearchTree<Person>();
//        for (int i = 0; i < data.length; i++) {
//            bst.add(new Person(data[i]));
//        }
//        BinaryTrees.println(bst);


        // 比较器传参：自定义排序
//        BinarySearchTree<Person> bst2 = new BinarySearchTree(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o2.getAge() - o1.getAge();
//            }
//        });
//        for (int i = 0; i < data.length; i++) {
//            bst2.add(new Person(data[i]));
//        }
//        BinaryTrees.println(bst2);

        // 随机数生成树打印
//        BinarySearchTree<Integer> bst3 = new BinarySearchTree<Integer>();
//        for (int i = 0; i < 40; i++) {
//            bst3.add((int) (Math.random()*100));
//        }

//        BinaryTrees.println(bst3);
        // 写入到文件测试
//        String str = BinaryTrees.printString(bst3);
//        Files.writeToFile("D:\\workspace\\fileTest\\tree.txt",str);

//        bst2.add(new Person(12));
//        bst2.add(new Person(15));
//
//        BinarySearchTree<Person> bst3 = new BinarySearchTree(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o2.getAge() - o1.getAge();
//            }
//        });
//        bst3.add(new Person(12));
//        bst3.add(new Person(15));

        // 测试值覆盖的情况
        test1();
    }

    public static void test1(){
        BinarySearchTree<Person> bst = new BinarySearchTree<Person>();
        bst.add(new Person(10,"jack"));
        bst.add(new Person(12,"jim"));
        bst.add(new Person(6,"rose"));
        bst.add(new Person(10,"perk"));
        BinaryTrees.println(bst);
    }
}
