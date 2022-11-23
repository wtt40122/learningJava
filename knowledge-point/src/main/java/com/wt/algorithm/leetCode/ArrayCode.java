package com.wt.algorithm.leetCode;

import java.util.*;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/16 13:42
 */
public class ArrayCode {

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (target < nums[middle]) {
                right = middle - 1;
            }
            if (target > nums[middle]) {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (target < nums[middle]) {
                right = middle;
            }
            if (target > nums[middle]) {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }

    /**
     * 双指针法
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[slowIndex] = nums[i];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static int[] sortedSquaresDoublePoint(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                result[k] = nums[right] * nums[right];
                right--;
            } else {
                result[k] = nums[left] * nums[left];
                left++;
            }
            k--;
        }
        int succeed;
        return result;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == target) {
                        result[1] = j;
                    }
                }
                break;
            }
        }
        return result;
    }

    public static int[] searchRangeBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[]{-1, -1};
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                result[0] = middle;
                result[1] = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result;
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int count = 1;
        while (true) {
            for (int j = left; j <= right; j++) {
                matrix[top][j] = count++;
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count++;
            }
            if (--right < left) {
                break;
            }
            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = count++;
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = count++;
            }
            if (++left > right) {
                break;
            }
        }
        return matrix;
    }

    public static int[][] generateMatrix2(int n) {
        int[][] matrix = new int[n][n];
        int loop = 0;
        int count = 1;
        int x = 0, y;
        int start = 0;
        while (loop++ < n / 2) {
            for (y = start; y < n - loop; y++) {
                matrix[start][y] = count++;
            }
            for (x = start; x < n - loop; x++) {
                matrix[x][y] = count++;
            }
            for (; y >= loop; y--) {
                matrix[x][y] = count++;
            }
            for (; x >= loop; x--) {
                matrix[x][y] = count++;
            }
            start++;
        }
        if (n % 2 != 0) {
            matrix[start][start] = n * n;
        }
        return matrix;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            for (int j = right; j >= left; j--) {
                list.add(matrix[bottom][j]);
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return list;
    }

    public static int[] spiralOrder2(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int[] arr = new int[matrix.length * matrix[0].length];
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int index = 0;
        while (true) {
            for (int j = left; j <= right; j++) {
                arr[index++] = matrix[top][j];
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                arr[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            for (int j = right; j >= left; j--) {
                arr[index++] = matrix[bottom][j];
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                arr[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return arr;
    }

    public static String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> originMap = new HashMap<>();
        Map<Character, Integer> sourceMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            originMap.put(c, originMap.getOrDefault(c, 0) + 1);
        }
        Integer size = s.length() + 1;
        String minStr = "";
        while (right < s.length()) {
            char c = s.charAt(right);
            sourceMap.put(c, sourceMap.getOrDefault(c, 0) + 1);
            right++;
            while (containsPer(originMap, sourceMap)) {
                if (right - left < size) {
                    minStr = s.substring(left, right);
                }
                size = Math.min(size, right - left);
                sourceMap.put(s.charAt(left), sourceMap.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }

        }
        return minStr;
    }

    private static boolean containsPer(Map<Character, Integer> oMap,
                                       Map<Character, Integer> sMap) {
        for (Map.Entry<Character, Integer> entry : oMap.entrySet()) {
            if (sMap.getOrDefault(entry.getKey(), 0) < (entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            right++;
            while (map.size() > 2) {
                if (map.get(fruits[left]) > 1) {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                } else {
                    map.remove(fruits[left]);
                }
                left++;
            }
            sum = Math.max(sum, right - left);
        }
        return sum;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int slowIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[slowIndex - 2] != nums[i]) {
                nums[slowIndex] = nums[i];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
//        System.out.println(binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 0));
//        System.out.println(removeElement1(new int[]{-1, 3, 3, 5, 9, 12, 3}, 3));
//        Arrays.stream(sortedSquaresDoublePoint(new int[]{-4, -1, 0, 3, 10})).forEach(System.out::println);
//        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
//        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
//        Arrays.stream(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).forEach(System.out::println);
//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }
}
