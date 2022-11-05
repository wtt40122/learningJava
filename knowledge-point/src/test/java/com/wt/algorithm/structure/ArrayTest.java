package com.wt.algorithm.structure;

import com.wt.algorithm.structure.array.ArrayList;
import com.wt.algorithm.structure.array.List;
import org.junit.Test;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/29 15:26
 */
public class ArrayTest {

    @Test
    public void test_array_list() {
        List<String> list = new ArrayList<>();
        list.add("01");
        list.add("02");
        list.add("03");
        list.add("04");
        list.add("05");
        list.add("06");
        list.add("07");
        list.add("08");
        list.add("09");
        list.add("10");
        list.add("11");
        list.add("12");

        System.out.println(list);

        list.remove(9);

        System.out.println(list);
    }
}
