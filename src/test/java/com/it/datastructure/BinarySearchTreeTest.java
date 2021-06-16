package com.it.datastructure;

import com.it.data_structure.printer.BinaryTrees;
import com.it.data_structure.tree.BinarySearchTree;
import com.it.pojo.Person;

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
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        // 打印
        BinaryTrees.println(bst);

        // 自定义对象的比较
        BinarySearchTree<Person> bst2 = new BinarySearchTree(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        bst2.add(new Person(12));
        bst2.add(new Person(15));

        BinarySearchTree<Person> bst3 = new BinarySearchTree(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        bst3.add(new Person(12));
        bst3.add(new Person(15));
    }
}
