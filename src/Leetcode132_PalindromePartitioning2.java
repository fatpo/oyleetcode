/*
132. Palindrome Partitioning II
Hard

560

21

Favorite

Share
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.



这道题依旧是动态规划

    d[i] = Min {
                dp[j] + 1, ( 0<j<=i )
                0 (j == 0)
           }

1、根据上面的状态转移方程，要找到上一个回文子串的边界 j，可能有 m 个这样子的回文串，所以需要for循环后取dp[i] = min(for j in [1, i])。
   特殊的，当j == 0 的时候，说明之前没有回文串，那么dp[i] = 0

2、要怎么才能才能判断一个子串是回文的呢？
   2.1 hw[j][i]是个回文串，那么hw[j+1][i-1]也是个回文串(j+1 < i-1)
       比如：abba，如果s[0] == s[3]，那么就继续考察 hw[1][2] 是不是一个回文串，如果是，则说明hw[0][3] 也是个回文串。
   2.2 hw[j][i]是个回文串，如果它满足( j+1 > i-1)，因为是j==i-1, 所以相邻2个字符啊，如果2个相邻相等字符，当然是回文串！！！
       比如：aa


 * */
public class Leetcode132_PalindromePartitioning2 {
    public static void main(String[] args) {
        System.out.println(minCut("aab"));
        System.out.println(minCut("abcdcb"));
        System.out.println(minCut("abcde"));
        System.out.println(minCut("aba"));
        System.out.println(minCut("abaabc"));
        System.out.println(minCut(""));
        System.out.println(minCut("a"));
        System.out.println(minCut("abbaaa"));
        System.out.println(minCut("abbab"));
    }

    public static int minCut(String s) {
        int n = s.length();
        if (n <= 1) {
            return 0;
        }

        // 初始化dp，默认都是最大的
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 存储回文状态，不用每次计算
        boolean[][] hwState = new boolean[n][n];

        // 动态规划
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 1、两个相邻的字符相等；2、最外层的遥遥相对的2个字符相等，并且它包含的那串字符串也是回文串。
                // 符合上面2个条件之一，就能去竞争最小dp[i] = dp[pos-1] + 1, pos 表示上一个回文串的位置...
                if (s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || hwState[j + 1][i - 1])) {
                    hwState[j][i] = true;
                    dp[i] = j == 0 ? 0 : Math.min(dp[j - 1] + 1, dp[i]);
                }
            }
        }
        return dp[n - 1];
    }

}