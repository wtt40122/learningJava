package com.wt.test;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @Auther: wtt
 * @Date: 2021/4/14 16:35
 * @Description:
 *
 * 重排链表
 * 限定语言：Python、C++、Java、Go、C、Javascript、Python 3
 * 将给定的单链表\ L L： L_0→L_1→…→L_{n-1}→L_ nL
 * 0
 * ​
 *  →L
 * 1
 * ​
 *  →…→L
 * n−1
 * ​
 *  →L
 * n
 * ​
 *
 * 重新排序为：L_0→L_n →L_1→L_{n-1}→L_2→L_{n-2}→…L
 * 0
 * ​
 *  →L
 * n
 * ​
 *  →L
 * 1
 * ​
 *  →L
 * n−1
 * ​
 *  →L
 * 2
 * ​
 *  →L
 * n−2
 * ​
 *  →…
 * 要求使用原地算法，不能改变节点内部的值，需要对实际的节点进行交换。
 * 例如：
 * 对于给定的单链表{1,2,3,4}，将其重新排序为{1,4,2,3}.
 */
public class Test {
    public static void main(String[] args) {
        // 获取CPU核数
        System.out.println(Runtime.getRuntime().availableProcessors());


        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01);
        // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));

        int[] array = {1, 3, 3, 4, 5, 6};
        //System.out.println(findFirstEqual(array, 3));
        System.out.println(findLastEqual(array, 3));
    }

    // 查找第一个相等的元素
    static int findFirstEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < array.length && array[left] == key) {
            return left;
        }

        return -1;
    }

    // 查找最后一个相等的元素
    static int findLastEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < array.length && array[right] == key) {
            return right;
        }
        return -1;
    }

    // 查找最后一个等于或者小于key的元素
    static int findLastEqualSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 查找最后一个小于key的元素
    static int findLastSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
