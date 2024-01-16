package com.wt.algorithm.other;

import java.util.*;

/**
 * @author wtt
 * @version 1.0
 * @description 哈希相关算法题
 * @date 2024/1/15 9:57
 */
public class MapCode {
    /**
     * 判断两个字符串是否是变位词-hash
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        if (tMap.size() != sMap.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (!sMap.getOrDefault(entry.getKey(), 0).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个字符串是否是变位词-数组
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            tCount[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个字符串是否是变位词-数组
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram3(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 组合变位词
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            map.put(sortedStr, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 2个数组求交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setRes = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                setRes.add(nums2[i]);
            }
        }
        return setRes.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 三数之和
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                List<Integer> list = new ArrayList<>();
                if (nums[i] + nums[left] + nums[right] == 0) {
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
                if (list.size() == 3) {
                    res.add(list);
                }
            }
        }
        return res;
    }

    /**
     * 四数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target && nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        System.out.println(isAnagram(s, t));
        System.out.println(threeSum(nums));
    }
}
