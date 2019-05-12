/*
122. Best Time to Buy and Sell Stock II
Easy

953

1265

Favorite

Share
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.



这个感觉都不算是动态规划啦。。
每个序列都能分为3种：
    1、递增序列 1,2,3
    2、递减序列 3,2,1
    3、混合序列 1,3,2
这道题就变成了，所有递增序列的两两差的和。比如7,1,5,3,6,4，两两相减，为正的就可以加起来啦，能赚一点是一点。。



* */

public class Leetcode122_BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxNum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                maxNum += prices[i] - prices[i - 1];
            }
        }
        return maxNum;
    }
}
