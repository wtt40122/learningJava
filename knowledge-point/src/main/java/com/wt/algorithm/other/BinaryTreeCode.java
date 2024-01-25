package com.wt.algorithm.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author wtt
 * @version 1.0
 * @description 二叉树相关的代码
 * @date 2024/1/25 16:35
 */
public class BinaryTreeCode {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 前序遍历-递归法
     * 中左右
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode treeNode, List<Integer> res) {
        if (null != treeNode) {
            res.add(treeNode.val);
            preOrder(treeNode.left, res);
            preOrder(treeNode.right, res);
        }
    }

    /**
     * 前序遍历-迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            if (null != treeNode.right) {
                stack.push(treeNode.right);
            }
            if (null != treeNode.left) {
                stack.push(treeNode.left);
            }
        }
        return res;
    }

    /**
     * 中序遍历-递归法
     * 左中右
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode node, List<Integer> res) {
        if (null != node) {
            inOrder(node.left, res);
            res.add(node.val);
            inOrder(node.right, res);
        }
    }

    /**
     * 中序遍历-迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (null != cur || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode treeNode = stack.pop();
                res.add(treeNode.val);
                cur = treeNode.right;
            }
        }
        return res;
    }

    /**
     * 后序遍历-递归法
     * 左右中
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(TreeNode node, List<Integer> res) {
        if (null != node) {
            postOrder(node.left, res);
            postOrder(node.right, res);
            res.add(node.val);
        }
    }

    /**
     * 后序遍历-迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            if (null != treeNode.left) {
                stack.push(treeNode.left);
            }
            if (null != treeNode.right) {
                stack.push(treeNode.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

}
