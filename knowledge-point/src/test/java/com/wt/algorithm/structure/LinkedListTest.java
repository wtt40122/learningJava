package com.wt.algorithm.structure;

import com.wt.algorithm.structure.linked_list.LinkedList;
import com.wt.algorithm.structure.linked_list.List;
import org.junit.Test;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/28 12:06
 */
public class LinkedListTest {

    @Test
    public void test_link_list() {
        List<String> list = new LinkedList<>();
        // 添加元素
        list.add("a");
        list.addFirst("b");
        list.addLast("c");
        // 打印列表
        list.printLinkList();
        // 头插元素
        list.addFirst("d");
        // 删除元素
        list.remove("b");
        // 打印列表
        list.printLinkList();
    }
}
