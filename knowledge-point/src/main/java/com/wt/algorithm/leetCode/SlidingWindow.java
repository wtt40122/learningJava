package com.wt.algorithm.leetCode;

import java.util.*;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/10/31 11:16
 */
public class SlidingWindow {
    /**
     * https://leetcode.cn/problems/maximum-average-subarray-i/
     *
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        double maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        double sum = maxSum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / k;
    }

    /**
     * https://leetcode.cn/problems/longest-nice-substring/
     *
     * @param s
     * @return
     */
    public static String longestNiceSubstring(String s) {
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                Boolean ifNice = checkNiceSubStringLength(s.substring(i, j + 1));
                if (ifNice && s.substring(i, j + 1).length() > maxLength) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    private static Boolean checkNiceSubStringLength(String s) {
        Set<Character> characters = new HashSet<>();
        for (char c : s.toCharArray()) {
            characters.add(c);
        }
        for (char c : s.toCharArray()) {
            if (!characters.contains(Character.toLowerCase(c)) ||
                    !characters.contains(Character.toUpperCase(c))) {
                return false;
            }
        }
        return true;
    }

    /**
     * https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
     *
     * @param nums
     * @param k
     * @return
     */
    public static int minimumDifference(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = k - 1; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i - k + 1]);
        }
        return min;
    }

    /**
     * https://leetcode.cn/problems/substrings-of-size-three-with-distinct-characters/
     *
     * @param s
     * @return
     */
    public static int countGoodSubstrings(String s) {
        int num = 0;
        int left = 0;
        int right = 0;
        while (right < s.length() && s.length() >= 3) {
            while (right - left < 3) {
                right++;
            }
            if (s.charAt(left) != s.charAt(left + 1) && s.charAt(left) != s.charAt(left + 2) &&
                    s.charAt(left + 1) != s.charAt(left + 2)) {
                num++;
            }
            left++;
        }
        return num;
    }

    /**
     * https://leetcode.cn/problems/find-the-k-beauty-of-a-number/
     *
     * @param num
     * @param k
     * @return
     */
    public static int divisorSubstrings(int num, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        String numStr = String.valueOf(num);
        while (right < numStr.length()) {
            while (right < left + k) {
                right++;
            }
            String substring = numStr.substring(left, right);
            if (Integer.parseInt(substring) != 0 && num % Integer.parseInt(substring) == 0) {
                count++;
            }
            left++;
        }
        return count;
    }

    /**
     * https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
     *
     * @param blocks
     * @param k
     * @return
     */
    public static int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = 0;
        int count = Integer.MAX_VALUE;
        List<Character> characterList = new LinkedList<>();
        while (right < blocks.length()) {
            while (right - left < k) {
                characterList.add(blocks.charAt(right));
                right++;
            }
            int countWhite = 0;
            for (Character character : characterList) {
                if (character == 'W') {
                    countWhite++;
                }
            }
            characterList.remove(0);
            left++;
            count = Math.min(count, countWhite);
        }
        return count;
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        int left = 0;
        int right = 0;
        Map<String, Integer> map = new HashMap<>();
        List<String> repeatedStrList = new ArrayList<>();
        while (right < s.length() && s.length() >= 10) {
            while (right - left < 10) {
                right++;
            }
            String substring = s.substring(left, right);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
            if (map.get(substring) == 2) {
                repeatedStrList.add(substring);
            }
            left++;
        }
        return repeatedStrList;
    }

    /**
     * https://leetcode.cn/problems/minimum-size-subarray-sum/
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int count = Integer.MAX_VALUE;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                sum = sum - nums[left];
                count = Math.min(count, right - left + 1);
                left++;
            }
            right++;
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }

    /**
     * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        int right = 0;
        List<Character> characters = new LinkedList<>();
        while (right < s.length()) {
            if (!characters.contains(s.charAt(right))) {
                characters.add(s.charAt(right));
                right++;
            } else {
                characters.remove(0);
            }
            count = Math.max(count, characters.size());
        }
        return count;
    }

    /**
     * https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/
     *
     * @param s
     * @param k
     * @return
     */
    public static int longestSubstring(String s, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            while (s.charAt(left) != s.charAt(right)) {
                right++;
            }
            while (map.getOrDefault(s.charAt(right), 0) < k && right < s.length()) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }
            left++;
            map.remove(s.charAt(left));
            count = Math.max(count, right - left);
        }
        return count;
    }

    /**
     * https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/submissions/
     * 超时
     *
     * @param nums
     * @param k
     * @return
     */
    public static long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        long sum = 0;
        long sumTemp = 0;
        List<Integer> list = new ArrayList<>();
        while (right < nums.length) {
            while (right - left < k) {
                list.add(nums[right]);
                sumTemp += nums[right];
                right++;
            }
            if (list.parallelStream().distinct().count() == k) {
                sum = Math.max(sum, sumTemp);
            }
            sumTemp -= nums[left];
            list.remove(0);
            left++;
        }
        return sum;
    }

    /**
     * https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/submissions/
     *
     * @param nums
     * @param k
     * @return
     */
    public static long maximumSubarraySum1(int[] nums, int k) {
        int left = 0;
        int right = 0;
        long sum = 0;
        long sumTemp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            while (right - left < k) {
                map.put(nums[right], right);
                sumTemp += nums[right];
                right++;
            }
            if (map.keySet().size() == k) {
                sum = Math.max(sum, sumTemp);
            }
            if (map.get(nums[left]) == left) {
                map.remove(nums[left]);
            }
            sumTemp -= nums[left];
            left++;
        }
        return sum;
    }

    public static int findLength1(int[] nums1, int[] nums2) {
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int k = 1;
                    while (i + k < nums1.length && j + k < nums2.length &&
                            nums1[i + k] == nums2[j + k]) {
                        k += 1;
                    }
                    result = Math.max(result, k);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
//        System.out.println(findMaxAverage(new int[]{5}, 1));
//        System.out.println(findMaxAverage(new int[]{-1}, 1));
//        System.out.println(findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1));
//        System.out.println(minimumDifference(new int[]{90}, 1));
//        System.out.println(countGoodSubstrings("xyzzaz"));
//        System.out.println(countGoodSubstrings("aababcabc"));
//        System.out.println(countGoodSubstrings("x"));

//        System.out.println(longestNiceSubstring("YazaAay"));
//        System.out.println(longestNiceSubstring("Bb"));
//        System.out.println(divisorSubstrings(240, 2));
//        System.out.println(divisorSubstrings(430043, 2));
//        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
//        findRepeatedDnaSequences("A").stream().forEach(System.out::println);
//        findRepeatedDnaSequences("AAAAAAAAAAAAA").stream().forEach(System.out::println);
//        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(longestSubstring("aaabb", 3));
//        System.out.println(maximumSubarraySum1(new int[]{9, 9, 9, 1, 2, 3}, 3));
//        System.out.println(maximumSubarraySum1(new int[]{4, 4, 4}, 3));
//        System.out.println(maximumSubarraySum1(new int[]{5, 3, 3, 1, 1}, 3));
        System.out.println(findLength1(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        ;
    }
}