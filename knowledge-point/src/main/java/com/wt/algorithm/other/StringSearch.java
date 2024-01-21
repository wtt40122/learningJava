package com.wt.algorithm.other;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2024/1/2 10:45
 */
public class StringSearch {

    public static int indexOf(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }


    public static int getLeftIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
                leftBorder = right;
            } else {
                left = mid + 1;
            }
        }
        return leftBorder;
    }

    public static int getRightIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftIndex = getLeftIndex(nums, target);
        int rightIndex = getRightIndex(nums, target);
        if (leftIndex == -2 || rightIndex == -2) {
            return new int[]{-1, -1};
        }
        if (rightIndex - leftIndex > 1) {
            return new int[]{leftIndex + 1, rightIndex - 1};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
//        String text = "ABABCABABCABCABC";
//        String pattern = "ABABC";
//
//        int result = indexOf(text, pattern);
//        System.out.println(result);
//        System.out.println(1 / 2);
        int[] arr = {2, 2};
        System.out.println(searchRange(arr, 3));
        System.out.println(isPerfectSquare(1));
    }

    public static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = mid * mid;
            if (res == num) {
                return true;
            } else if (res > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] getNext(String s) {
        int[] next = new int[s.length()];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


}
