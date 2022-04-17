package com.wt.test;

import com.wt.algorithm.leetCode.ListNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: wtt
 * @Date: 2021/5/11 20:41
 * @Description:
 */
@Slf4j
public class ListTest {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);
        System.out.println(String.format("list:%s size:%s class:%s", list, list.size(), list.get(0).getClass()));
        int[] arr1 = {1, 2, 3};
        List list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        System.out.println(String.format("list:%s size:%s class:%s", list1, list1.size(), list1.get(0).getClass()));
    }

}
