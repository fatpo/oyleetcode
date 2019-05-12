/*
* 64. Minimum Path Sum
Medium

1304

38

Favorite

Share
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7

Explanation: Because the path 1→3→1→1→1 minimizes the sum.


这道理求从左上角 -> 右下角的最短路径，比如 1> 3> 1 > 1 > 1 = 7


dp[i][j] = min {
                dp[i-1][j] + s[i][j]  // 从上方 ↓
                dp[i][j-1] + s[i][j]  // 从左方 →
            }


* */

public class Leetcode64_MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 2, 3}, {3, 4, 5}, {1, 1, 1}}));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // 初始化 第一列
        int status[][] = new int[grid.length][grid[0].length];
        status[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            status[i][0] = grid[i][0] + status[i - 1][0];
        }

        // 初始化 第一行
        for (int i = 1; i < grid[0].length; i++) {
            status[0][i] = grid[0][i] + status[0][i - 1];
            ;
        }

        // 动态规划
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                status[i][j] = Math.min(status[i - 1][j], status[i][j - 1]) + grid[i][j];
            }
        }
        return status[grid.length - 1][grid[0].length - 1];
    }
}
