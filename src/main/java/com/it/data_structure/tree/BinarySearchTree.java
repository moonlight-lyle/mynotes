package com.it.data_structure.tree;

import com.it.data_structure.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * 二叉搜索树的实现
 * 实现BinaryTreeInfo接口进行打印
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {

    // size
    private int size;

    // 根节点
    private Node<E> root;

    // 比较器
    private Comparator<E> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * 实现打印的方法开始
     */
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        // 只打印节点元素的情况
        return ((Node<E>)node).element;
        // 打印父节点及元素节点
//        Node<E> myNode = (Node<E>) node;
//        String parentStr = "null";
//        if (myNode.parent != null) {
//            parentStr = myNode.parent.element.toString();
//        }
////        return "parentNode:" + parentStr + "_" + "currentNode:" + myNode.element;
//        return "currentNode:" + myNode.element;
    }
    /**
     *实现打印的方法结束
     */


    /**
     * 节点类
     *
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        // 构造方法
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            // 创建根节点
            root = new Node<>(element, null);
            size++;
            return;
        } else {
            // 添加的不是根节点
            // 先从根节点找到父节点
            Node<E> node = root;
            // 记录父节点和比较的结果
            Node<E> parent = null;
            int cmp = 0;
            while (node != null) {
                cmp = compare(element, node.element);
                parent = node;
                if (cmp > 0) {
                    // element>node.element,找到node的右节点
                    node = node.right;

                } else if (cmp < 0) {
                    // element<node.element,找到node的左节点
                    node = node.left;
                } else {
                    // 相等
                    // 处理方法一：覆盖
                    node.element = element;
                    return;
                    // 处理方法二：不做任何处理
//                    return;
                }
            }
            // 找到父节点后，插入新的节点
            Node<E> newNode = new Node<>(element, parent);
            if (cmp > 0) {
                // 插入到父节点的右边
                parent.right = newNode;
            } else {
                // 小于0，插入到父节点的左边
                parent.left = newNode;
            }
            size++;
        }

    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }

    /**
     * 自定义比较方法
     * 返回值为0：e1==e2
     * 返回值大于0：e1>e2
     * 返回值为小于0：e1<e2
     *
     * @param e1
     * @param e2
     * @return
     */

    private int compare(E e1, E e2) {
        // 如果有比较器，优先使用比较器
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        // 如果没有构造器，强制必须实现Comparable接口
        return ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * 二叉搜索树元素不能为null，所以需要进行非空判断
     *
     * @param element
     */
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * 开始：
     * 前序遍历的实现：递归方式
     */
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node<E> node) {
        // 如果node为null，直接结束返回
        if (node == null) {
            return;
        }
        // 先访问根节点
        System.out.println(node.element);
        // 接着递归访问左子树
        preorderTraversal(node.left);
        // 最后递归访问右子树
        preorderTraversal(node.right);
    }

    /**
     * 结束：
     * 中序遍历的实现：递归方式
     */

    /**
     * 开始：
     * 前序遍历的实现：递归方式
     */
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node<E> node) {
        // 如果node为null，直接结束返回
        if (node == null) {
            return;
        }
        // 先递归访问左子树
        inorderTraversal(node.left);
        // 打印节点元素
        System.out.println(node.element);
        // 最后递归访问右子树
        inorderTraversal(node.right);
    }

    /**
     * 结束：
     * 中序遍历的实现：递归方式
     */
}
