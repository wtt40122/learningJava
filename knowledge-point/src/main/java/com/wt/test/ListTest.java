package com.wt.test;

import com.wt.algorithm.leetCode.ListNode;

/**
 * @Auther: wtt
 * @Date: 2021/5/11 20:41
 * @Description:
 */
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

}
