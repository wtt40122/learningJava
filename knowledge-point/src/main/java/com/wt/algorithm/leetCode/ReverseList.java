package com.wt.algorithm.leetCode;

/**
 * @Auther: wtt
 * @Date: 2021/2/12 16:31
 * @Description: 反转链表
 */
public class ReverseList {
    /**
     *
     * @Description //非递归实现
     * @Author wtt
     * @Date 2021/2/12 16:40
     * @param: [head]
     * @return com.wt.algorithm.leetCode.ListNode
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    /**
     *
     * @Description //递归实现
     * @Date 2021/2/12 16:40
     * @param: [head]
     * @return com.wt.algorithm.leetCode.ListNode
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rev = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

    public static ListNode reverseList3(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
    }
        return prev;
    }

    public static int rebuildNum(int num) {
        if (num <= 0) {
            //如果num<=0，直接返回2的0次幂
            return 1;
        } else if ((num & (num - 1)) == 0) {
            //如果num是2的乘方，则直接返回num
            return num;
        } else {
            //找到大于以2为底num的对数最近的整数
            //例：num=7,以2为底7的对数为：2.807...，强转int再加1结果为：3
            int tmp = (int) (Math.log(num) / Math.log(2)) + 1;
            //求2的tmp次幂
            return (int) Math.pow(2, tmp);
        }
    }


    public static int twoPowerMin(int num){
        int max = 1 << 30;
        int n = num - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n < 0 ? 1 : (n >= max ? max : n + 1);
    }

    public static void main(String[] args) {
        System.out.println(rebuildNum(6));
        System.out.println(twoPowerMin(6));
    }


}
