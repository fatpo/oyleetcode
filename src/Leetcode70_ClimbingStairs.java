/*
*
70. Climbing Stairs
Easy

2109

79

Favorite

Share
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

动态规划：
    dp[i] 表示当前的跳跃方案...
    可能从2个状态过来:
        1、dp[i-1]的时候，跳一步，跳过来的...
        2、dp[i-2]的时候，跳2步，跳过来的....
        3、取上面1和2的方案之和，就是dp[i]总的方案啦~

    dp[i] = dp[i - 1] + dp[i - 2]


*
*
* */

public class Leetcode70_ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(30));
    }


    public static int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        // 初始化
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }


}
