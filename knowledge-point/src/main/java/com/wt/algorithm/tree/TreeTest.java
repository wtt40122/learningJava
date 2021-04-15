package com.wt.algorithm.tree;

import org.junit.Test;

/**
 * @Auther: wtt
 * @Date: 2021/3/27 14:42
 * @Description:
 */
public class TreeTest {

    @Test
    public void testBST() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree();
        Integer[] nums = {3, 6, 2, 1, 4, 9};
        for (int i = 0; i < nums.length; i++) {
            binarySearchTree.add(nums[i]);
        }
        System.out.println("是否包含1：" + binarySearchTree.contain(1));
        System.out.println("是否包含8：" + binarySearchTree.contain(8));
        binarySearchTree.preOrder();
    }
}
