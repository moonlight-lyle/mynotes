package com.it.data_structure.tree;

/**
 * 二叉搜索树的实现
 */
public class BinarySearchTree<E> {

    // size
    private int size;

    // 根节点
    private Node<E> root;

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
                    return;
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
        return 0;
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
}
