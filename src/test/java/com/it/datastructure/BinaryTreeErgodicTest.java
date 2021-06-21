package com.it.datastructure;

import com.it.data_structure.printer.BinaryTrees;
import com.it.data_structure.tree.BinarySearchTree;

/**
 * 二叉树的遍历测试
 */
public class BinaryTreeErgodicTest {
    public static void main(String[] args) {
        preorderTraversalTest();
    }

    /**
     * 前序遍历测试：递归方法
     */
    public static void preorderTraversalTest() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        // 打印
        BinaryTrees.println(bst);
        // 遍历
        System.out.println("============================遍历开始===================================");
        // 前序遍历
//        bst.preorderTraversal();

        // 中序遍历
        bst.inorderTraversal();
        System.out.println("============================遍历结束===================================");
    }
}
