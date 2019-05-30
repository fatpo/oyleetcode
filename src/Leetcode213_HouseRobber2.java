/**
 * Created by ouyang on 2019/5/27.
 * 213. House Robber II
 * Medium
 * 
 * 862
 * 
 * 30
 * 
 * Favorite
 * 
 * Share
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * Example 1:
 * 
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 * because they are adjacent houses.
 * Example 2:
 * 
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * 简单的dp：
 * dp[i] = max(dp[i-1], dp[i-2]+nums[i])
 * 但是因为首尾相连，所以我们需要计算。。。
 * 
 * 1、0->n-2 ，然后得到 dp[n-2]
 * 2、1->n-1 ，然后得到 dp[n-1]
 * 
 * 返回两者中最大的！！！
 */
public class Leetcode213_HouseRobber2 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 34, 4}));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        // 从0->n-1
        for (int i = 0; i < n - 1; i++) {
            if (i == 0) {
                dp1[i] = nums[0];
            } else if (i == 1) {
                dp1[i] = Math.max(nums[0], nums[1]);
            } else {
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
            }
        }

        // 从1->n
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dp2[i] = nums[1];
            } else if (i == 2) {
                dp2[i] = Math.max(nums[1], nums[2]);
            } else {
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
            }
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);


    }
}

