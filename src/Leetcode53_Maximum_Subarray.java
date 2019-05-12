/*
*
* 53. Maximum Subarray
Easy

4148

143

Favorite

Share
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

这道题求最大子序列和，比如 [1,2,3,-4] 的最大子序列和就是1+2+3 = 6
dp[i] = dp[i-1] + s[i]  // 如果考虑第i个元素，确实有利于最大子序列的和，那么就把它加入进来。
      = s[i] // 前面的都不堪重用，直接从第i个元素开始另起炉灶

*
*
* */

public class Leetcode53_Maximum_Subarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1, 2, 3}));
        System.out.println(maxSubArray(new int[]{1, 2, 3, -4}));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];

        if (nums.length == 0) {
            return 0;
        }

        // 初始化
        dp[0] = nums[0];
        int maxSum = nums[0];

        // 动态规划
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
