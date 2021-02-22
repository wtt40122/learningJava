package com.wt.algorithm.leetCode;

/**
 * @Auther: wtt
 * @Date: 2021/2/13 13:30
 * @Description: 给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode resTemp = res;
        int nextSum = 0;
        int flag = 0;
        while (l1 != null && l2 != null) {
            int p;
            if (flag == 0) {
                p = l1.val + l2.val;
                res.val = p % 10;
                nextSum = p / 10;
                flag++;
            } else {
                p = l1.val + l2.val + nextSum;
                resTemp.next = new ListNode(p % 10);
                resTemp = resTemp.next;
                nextSum = p / 10;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int p = l1.val + nextSum;
            resTemp.next = new ListNode(p % 10);
            resTemp = resTemp.next;
            nextSum = p / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int p = l2.val + nextSum;
            resTemp.next = new ListNode(p % 10);
            resTemp = resTemp.next;
            nextSum = p / 10;
            l2 = l2.next;
        }
        if (nextSum != 0) {
            resTemp.next = new ListNode(nextSum);
        }
        return res;
    }

    public ListNode addTwoNum(ListNode l1,ListNode l2){
        ListNode res = new ListNode(-1);
        ListNode head = res;
        int addOne = 0;
        while(l1 != null || l2 != null || addOne != 0){
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + addOne;
            res.next = new ListNode(sum % 10);
            addOne = sum /10 ;
            res = res.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return head.next;
    }
}
