package com.wt.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/29 0:51
 */
public class TreeCode {
    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        treeTraversalBefore(root, list);
        return list;
    }

    private void treeTraversalBefore(TreeNode treeNode, List<Integer> list) {
        if (null != treeNode) {
            list.add(treeNode.val);
            treeTraversalBefore(treeNode.left, list);
            treeTraversalBefore(treeNode.right, list);
        }
    }

    /**
     * 后续遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        treeTraversalAfter(root, list);
        return list;
    }

    private void treeTraversalAfter(TreeNode treeNode, List<Integer> list) {
        if (null != treeNode) {
            treeTraversalAfter(treeNode.left, list);
            treeTraversalAfter(treeNode.right, list);
            list.add(treeNode.val);
        }
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        treeTraversalMiddle(root, list);
        return list;
    }

    private void treeTraversalMiddle(TreeNode treeNode, List<Integer> list) {
        if (null != treeNode) {
            treeTraversalMiddle(treeNode.left, list);
            list.add(treeNode.val);
            treeTraversalMiddle(treeNode.right, list);
        }
    }
}
