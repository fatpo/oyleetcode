/*
322. Coin Change
Medium

1673

73

Favorite

Share
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.


这道题依旧是动态规划，考察第i个元素，可以从什么状态过来？
1、从i-1  + 1个1元硬币过来
2、从i-2  + 1个2元硬币过来
2、从i-5  + 1个5元硬币过来

dp[i] = min{
            dp[i-1] + 1,
            dp[i-2] + 1,
            dp[i-5] + 1
            }
*
* */

import java.util.Arrays;

public class Leetcode322_CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{3}, 2));
        System.out.println(coinChange(new int[]{1, 2, 3}, 9));
        System.out.println(coinChange(new int[]{1}, 10));
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int dp[] = new int[amount + 1];


        // 硬币排序，保证从小到大的顺序
        Arrays.sort(coins);

        // 初始化
        dp[0] = 0;

        // 开始动态规划
        for (int i = 1; i <= amount; i++) {
            int tmpMin = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] >= 0) {
                    tmpMin = Math.min(dp[i - coins[j]], tmpMin);
                }
            }

            // 判断不符合条件的，-1
            if (tmpMin != Integer.MAX_VALUE) {
                dp[i] = tmpMin + 1;
            } else {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }

}
