package com.panyu.jase.algorithm;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        String s = "abpcplea";
        ArrayList<String> d = new ArrayList<>(Arrays.asList("ale", "apple", "monkey", "plea"));
        findLongestWord(s, d);
    }

    // Input:
    //s = "abpcplea", d = ["ale","apple","monkey","plea"]
    //
    //Output:
    //"apple"
    //题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。
    public static String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private static boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }


    // 判断链表是否存在环
//    public boolean hasCycle(ListNode head) {
//        if (head == null) {
//            return false;
//        }
//        ListNode l1 = head, l2 = head.next;
//        while (l1 != null && l2 != null && l2.next != null) {
//            if (l1 == l2) {
//                return true;
//            }
//            l1 = l1.next;
//            l2 = l2.next.next;
//        }
//        return false;
//    }

    // 题目描述：把归并结果存到第一个数组上。
    //Input:
    //nums1 = [1,2,3,0,0,0], m = 3
    //nums2 = [2,5,6],       n = 3
    //
    //Output: [1,2,2,3,5,6]
    // int[] nums1 = {1, 2, 3, 0, 0, 0};
    //        int m = 3;
    //        int[] nums2 = {2, 5, 6};
    //        int n = 3;
    public static void mergeNum(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }

    // 题目描述：可以删除一个字符，判断是否能构成回文字符串。
    public static boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


    // 元音字母
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    // 反转字符串中的元音字符
    public static String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    // 题目描述：判断一个非负整数是否为两个整数的平方和。
    public static boolean judgeSquareSum(int target) {
        if (target < 0) return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    // 题目描述：在有序数组中找出两个数，使它们的和为 target。
    public static void twoSumSolution() {
        int[] arr = {2, 7, 11, 13};
//        int[] ints = twoSum(arr, 13);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
        int[] ints1 = twoSum2(arr, 9);
        for (int i : ints1) {
            System.out.println(i);
        }
    }

    public static int[] twoSum2(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


}
