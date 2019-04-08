package com.yyy.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

/**
 * @author : ytw
 * @date : 2019-03-15
 * description :
 **/
public class BinaryTree {

    private Node root;

    @Before
    public void before() {
        root = new Node(null, null, null, 1);
        Node node2 = new Node(root, null, null, 2);
        Node node3 = new Node(root, null, null, 3);
        root.setLeft(node2).setRight(node3);
        Node node4 = new Node(node2, null, null, 4);
        Node node5 = new Node(node3, null, null, 5);
        node2.setLeft(node4);
        node3.setRight(node5);
        Node node6 = new Node(node4, null, null, 6);
        Node node7 = new Node(node6, null, null, 7);
        Node node8 = new Node(node6, null, null, 8);
        node4.setRight(node6);
        node6.setLeft(node7);
        node6.setRight(node8);
    }

    public void preorder(Node root) {
        System.out.println(root);
        if (root.left != null) {
            preorder(root.left);
        }
        if (root.right != null) {
            preorder(root.right);
        }
    }

    public void midorder(Node root) {
        if (root.left != null) {
            midorder(root.left);
        }
        System.out.println(root);
        if (root.right != null) {
            midorder(root.right);
        }
    }

    public void lastorder(Node root) {
        if (root.left != null) {
            lastorder(root.left);
        }
        if (root.right != null) {
            lastorder(root.right);
        }
        System.out.println(root);
    }

    @Test
    public void testPreOrder() {
        preorder(root);
    }

    @Test
    public void testMidorder() {
        midorder(root);
    }

    @Test
    public void testLastorder() {
        lastorder(root);
    }

    @Test
    public void testNoneRecursionPreorder() {
        Node node = root;
        //保存节点，为了遍历完左孩子后能找到节点的右孩子
        Stack<Node> stack = new Stack<Node>();
        //node ==null && stack也空了，说明遍历完了
        while (node != null || !stack.isEmpty()) {
            //循环遍历左孩子，直到没有左孩子
            while (node != null) {
                System.out.println(node);
                stack.push(node);
                node = node.left;
            }
            //走到这里说明没有左孩子了，取出父节点，开始遍历右孩子(可能为null)
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    @Test
    public void testNoneRecusionMidorder() {
        Node node = root;
        Stack<Node> stack = new Stack<Node>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node);
                node = node.right;
            }
        }
    }

    @Test
    public void testNoneRecusionLastorder() {
        Node node = root;
        Node lastVisit = root;
        Stack<Node> stack = new Stack<Node>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || lastVisit == node.right) {
                System.out.println(node);
                stack.pop();
                lastVisit = node;
                node = null;
            } else {
                node = node.right;
            }
        }
    }


    public static class Node {

        public Node parent;

        public Node left;

        public Node right;

        public int val;

        public Node(Node parent, Node left, Node right, int val) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.val = val;
        }

        public Node() {
        }


        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node setLeft(Node left) {
            this.left = left;
            return this;
        }

        public Node setRight(Node right) {
            this.right = right;
            return this;
        }

        public Node setVal(int val) {
            this.val = val;
            return this;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}

