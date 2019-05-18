/*
63. Unique Paths II
Medium

833

115

Favorite

Share
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.
Note: m and n will be at most 100.
Example 1:
Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

简单的动态规划
    dp[i][j] = dp[i-1][j] + dp[i][j-1]
我在某一格子的路线 = 从上面下来的路线 + 从左边过来的路线

但是有障碍，所以把障碍特殊考虑一下就好，有障碍就不走了呗...


 * */

public class Leetcode63_UniquePaths2 {

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 1}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // 初始化第一列
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                if (i == 0) {
                    dp[i][0] = 1;
                } else {
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }
        // 初始化第一行
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                if (j == 0) {
                    dp[0][j] = 1;
                } else {
                    dp[0][j] = dp[0][j - 1];
                }
            }
        }

        // 开始动态规划
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    // 上面能走下来
                    if (obstacleGrid[i - 1][j] == 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    // 左边能走过去右边
                    if (obstacleGrid[i][j - 1] == 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}