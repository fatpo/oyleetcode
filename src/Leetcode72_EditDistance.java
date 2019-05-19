/*
72. Edit Distance
Hard

2019

30

Favorite

Share
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')



这道题是典型的动态规划。
dp[i][j] 可以从三种状态得到：
    1、从dp[i-1][j-1] 直接过来，这里又分2个情况
            1.1 如果word[i] == word[j]，那么dp[i][j] = dp[i-1][j-1]（2个字符串同时往前跳1步，不需增加编辑距离）
            1.2 如果word[i] != word[j]，那么dp[i][j] = dp[i-1][j-1] + 1（上面字符替换为下面字符，2串同时往前跳1步，增加编辑距离1）
    2、从dp[i-1][j] 直接过来，意思是，上面的串+1指针，下面的串不动，便是上面串删除了一个字符的意思。
    3、从dp[i][j-1]直接过来，意思是：上面的串指针不动，下面的串往前+1，这就是上面的串+1个新字符的意思。

转移方程：
dp[i][j] = min {
                dp[i-1][j-1](+1 这里加不加1看情况),
                dp[i-1][j] + 1,
                dp[i][j-1] + 1
          }

ps:
这道题其实思路一致很清晰，我知道它当前状态可能从3个状态演变过来，
但是因为下标问题，i和j一致跳来跳去（要么同时动，要么i动j不动，j动i不动）思路就乱了。
后来想着，算了，用二维表来演算，反而清晰多了。

 * */

public class Leetcode72_EditDistance {

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }

    public static int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        int[][] dp = new int[m][n];

        // 初始化第一行
        boolean findFlag = false;
        for (int j = 0; j < n; j++) {
            if (word1.charAt(0) == word2.charAt(j) && !findFlag) {
                dp[0][j] = j >= 1 ? dp[0][j - 1] : 0;
                findFlag = true;
            } else {
                dp[0][j] = j >= 1 ? dp[0][j - 1] + 1 : 1;
            }
        }

        // 初始化第一列
        findFlag = false;
        for (int i = 0; i < m; i++) {
            if (word1.charAt(i) == word2.charAt(0) && !findFlag) {
                dp[i][0] = i >= 1 ? dp[i - 1][0] : 0;
                findFlag = true;
            } else {
                dp[i][0] = i >= 1 ? dp[i - 1][0] + 1 : 1;
            }
        }

        // 开始动态规划
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = myMin(dp[i - 1][j - 1], dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                } else {
                    dp[i][j] = myMin(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }


        return dp[m - 1][n - 1];
    }

    public static int myMin(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        }
        if (b <= a && b <= c) {
            return b;
        }
        if (c <= a && c <= b) {
            return c;
        }
        return -1;
    }
}