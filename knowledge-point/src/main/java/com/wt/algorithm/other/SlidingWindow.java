package com.wt.algorithm.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2024/1/5 9:54
 */
public class SlidingWindow {
    /**
     * 长度最小的子序列-暴力解法
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    result = Integer.min(result, j - i + 1);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * 长度最小的子序列--滑动窗口
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int resul = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                resul = Integer.min(resul, right - left + 1);
                sum -= nums[left++];
            }
        }
        return resul == Integer.MAX_VALUE ? 0 : resul;
    }

    public static int totalFruit(int[] fruits) {
        int i = 0, j;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (j = 0; j < fruits.length; j++) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            while (map.size() > 2) {
                if (map.get(fruits[i]) > 1) {
                    map.put(fruits[i], map.get(fruits[i]) - 1);
                } else {
                    map.remove(fruits[i]);
                }
                i++;
            }
            count = Math.max(count, j - i + 1);
        }
        return count;
    }

    public static int lengthOfLongestSubstring(String s) {
        int i, j = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (!isRepeat(map)) {
                if (map.get(s.charAt(j)) > 1) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                } else {
                    map.remove(s.charAt(j));
                }
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    private static boolean isRepeat(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return false;
            }
        }
        return true;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int i, j = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.get(s.charAt(i)) > 1) {
                if (map.get(s.charAt(j)) > 1) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                } else {
                    map.remove(s.charAt(j));
                }
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int count = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res[top][i] = count++;
            }
            if (++top > bottom) {
                break;
            }
            for (int j = top; j <= bottom; j++) {
                res[j][right] = count++;
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[bottom][i] = count++;
            }
            if (--bottom < top) {
                break;
            }
            for (int j = bottom; j >= top; j--) {
                res[j][left] = count++;
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }
            for (int j = top; j <= bottom; j++) {
                res.add(matrix[j][right]);
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top) {
                break;
            }
            for (int j = bottom; j >= top; j--) {
                res.add(matrix[j][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    public int[] spiralArray(int[][] array) {
        if (array.length == 0) {
            return new int[0];
        }
        int[] res = new int[array.length * array[0].length];
        int top = 0, bottom = array.length - 1, left = 0, right = array[0].length - 1;
        int count = 0;
        while (true) {
            for (int i = left; i <= right; i++) {
                res[count++] = array[top][i];
            }
            if (++top > bottom) {
                break;
            }
            for (int j = top; j <= bottom; j++) {
                res[count++] = array[j][right];
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[count++] = array[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res[count++] = array[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring1(s));
        generateMatrix(3);
    }
}
