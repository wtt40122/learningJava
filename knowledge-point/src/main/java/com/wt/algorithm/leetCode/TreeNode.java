package com.wt.algorithm.leetCode;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/29 0:51
 */
public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;


    public TreeNode() {

    }

    public TreeNode(Integer value) {
        this.val = value;
    }

    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.val = value;
        this.left = left;
        this.right = right;
    }
}
