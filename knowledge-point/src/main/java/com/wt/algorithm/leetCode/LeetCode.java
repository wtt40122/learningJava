package com.wt.algorithm.leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode {
    /**
     * 有多少小于当前数字的数字
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numsCount = new int[nums.length];
        for (int i = 0; i < numsCount.length; i++) {
            int count = 0;
            int target = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < target) {
                    count++;
                }
            }
            numsCount[i] = count;
        }
        return numsCount;
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < arr.length - 1 && arr[left] < arr[left + 1]) {
            left++;
        }
        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        if (left == right && left != 0 && right != arr.length - 1) {
            return true;
        }
        return false;
    }

    /**
     * 独一无二的出现次数
     *
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            set.add(value);
        }
        return set.size() == map.size();
    }

    /**
     * 全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, new int[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void backTrack(int[] nums, int[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backTrack(nums, used, path, result);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    /**
     * N皇后
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] chessBoard = new char[n][n];
        for (char[] c : chessBoard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessBoard, result);
        return result;
    }

    private void backTrack(int n, int row, char[][] chessBoard, List<List<String>> result) {
        if (row == n) {
            result.add(Arrays.stream(chessBoard).map(String::valueOf).collect(Collectors.toList()));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessBoard)) {
                chessBoard[row][col] = 'Q';
                backTrack(n, row + 1, chessBoard, result);
                chessBoard[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] chessBoard) {
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * 子集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, 0, new ArrayList(), result);
        return result;
    }

    private void backTrack(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode code = new LeetCode();
        int[] nums = {0, 3, 2, 1};
        code.smallerNumbersThanCurrent(nums);
        code.validMountainArray(nums);
    }
}
