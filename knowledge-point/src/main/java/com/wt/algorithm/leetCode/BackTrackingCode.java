package com.wt.algorithm.leetCode;

import java.util.*;

/**
 * @author: wtt
 * @date: 2022/12/6 22:05
 * @description: 回溯算法
 */
public class BackTrackingCode {

    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Description 组合问题
     * @Author wtt
     * @Date 2022/12/7 23:03
     * @param: [n, k]
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backTracking(n, k, 1, new ArrayList<>(), list);
        return list;
    }

    private void backTracking(int n, int k, int startIndex,
                              List<Integer> result, List<List<Integer>> list) {
        if (result.size() == k) {
            list.add(new ArrayList<>(result));
            return;
        }
        for (int i = startIndex; i <= n - (k - result.size()) + 1; i++) {
            result.add(i);
            backTracking(n, k, i + 1, result, list);
            result.remove(result.size() - 1);
        }
    }

    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Description 组合求和
     * @Author wtt
     * @Date 2022/12/7 23:03
     * @param: [k, n]
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backTracking3(n, k, 1, 0, new ArrayList<>(), list);
        return list;
    }

    private void backTracking3(int n, int k, int startIndex, int sum,
                               List<Integer> result, List<List<Integer>> list) {
        if (sum > n) {
            return;
        }
        if (result.size() == k) {
            if (sum == n) {
                list.add(new ArrayList<>(result));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - (k - result.size()) + 1; i++) {
            result.add(i);
            backTracking3(n, k, i + 1, sum + i, result, list);
            result.remove(result.size() - 1);
        }
    }

    /**
     * @return java.util.List<java.lang.String>
     * @Description 电话号码组合问题
     * @Author wtt
     * @Date 2022/12/7 23:02
     * @param: [digits]
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        trackLetter(digits, 0, list, map, new StringBuilder());
        return list;
    }


    private void trackLetter(String digits, int index, List<String> list,
                             Map<Character, String> map, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }
        Character charStr = digits.toCharArray()[index];
        String str = map.get(charStr);
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            trackLetter(digits, index + 1, list, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 组合总和II
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backTracking2(candidates, target, 0, 0, new int[candidates.length], new ArrayList(), result);
        return result;
    }

    private void backTracking2(int[] candidates, int target, int sum,
                               int startIndex, int[] used, List<Integer> list, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }
            list.add(candidates[i]);
            used[i] = 1;
            backTracking2(candidates, target, sum + candidates[i], i + 1, used, list, result);
            used[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    /**
     * 切割回文字符串
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        backTrackingPartition(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTrackingPartition(String s, int startIndex, List<String> path, List<List<String>> result) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (!isPalindrome(s, startIndex, i)) {
                continue;
            }
            path.add(s.substring(startIndex, i + 1));
            backTrackingPartition(s, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }

    /**
     * 复原IP地址
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        backTrackingIp(new StringBuilder(s), 0, 0, result);
        return result;
    }

    private void backTrackingIp(StringBuilder sb, int starIndex, int positionNum, List<String> result) {
        if (positionNum == 3) {
            if (isValid(sb.toString(), starIndex, sb.toString().length() - 1)) {
                result.add(sb.toString());
            }
            return;
        }
        for (int i = starIndex; i < sb.toString().length(); i++) {
            if (isValid(sb.toString(), starIndex, i)) {
                sb.insert(i + 1, ".");
                positionNum++;
                backTrackingIp(sb, i + 2, positionNum, result);
                positionNum--;
                sb.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }

    private boolean isValid(String s, int startedIndex, int endIndex) {
        if (startedIndex > endIndex) {
            return false;
        }
        if (s.charAt(startedIndex) == '0' && startedIndex != endIndex) {
            return false;
        }
        String substring = s.substring(startedIndex, endIndex + 1);
        long value = Long.parseLong(substring);
        if (value >= 0L && value <= 255L) {
            return true;
        }
        return false;
    }

    /**
     * 子集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        backTrackingSub(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTrackingSub(int[] nums, int startIndex, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTrackingSub(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 子集II
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        backTrackingDup(nums, 0, new int[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void backTrackingDup(int[] nums, int startIndex, int[] used, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backTrackingDup(nums, i + 1, used, path, result);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    /**
     * 递增子序列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        backTrackingFind(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTrackingFind(int[] nums, int startIndex, List<Integer> path, List<List<Integer>> result) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if ((path.size() > 0 && nums[i] > path.get(path.size() - 1)) || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            backTrackingFind(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        backTrackingPermute(nums, new int[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void backTrackingPermute(int[] nums, int[] used, List<Integer> path, List<List<Integer>> result) {
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
            backTrackingPermute(nums, used, path, result);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    /**
     * 全排列II
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        backTrackingUnique(nums, new int[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void backTrackingUnique(int[] nums, int[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backTrackingUnique(nums, used, path, result);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    /**
     * 机场航班问题
     *
     * @param tickets
     * @return
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(ticket.get(0))) {
                temp = map.get(ticket.get(0));
                temp.put(ticket.get(1), temp.getOrDefault(ticket.get(1), 0) + 1);
            } else {
                temp = new TreeMap<>();
                temp.put(ticket.get(1), 1);
            }
            map.put(ticket.get(0), temp);
        }
        LinkedList<String> result = new LinkedList<>();
        result.add("JFK");
        backTrackingIt(map, tickets.size(), result);
        return result;
    }

    private boolean backTrackingIt(Map<String, Map<String, Integer>> map, int ticketNum, LinkedList<String> result) {
        if (result.size() == ticketNum + 1) {
            return true;
        }
        String last = result.getLast();
        if (map.containsKey(last)) {
            for (Map.Entry<String, Integer> entry : map.get(last).entrySet()) {
                int count = entry.getValue();
                if (count > 0) {
                    result.add(entry.getKey());
                    entry.setValue(count - 1);
                    if (backTrackingIt(map, ticketNum, result)) {
                        return true;
                    }
                    result.removeLast();
                    entry.setValue(count);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BackTrackingCode code = new BackTrackingCode();
        List<String> combine = code.restoreIpAddresses("25525511135");
        combine.stream().forEach(System.out::println);
    }
}
