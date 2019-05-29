/**
 * 97. Interleaving String
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 *
 *
 * 这道题还是用动态规划
 * dp[i][j] 表示字符s1的i位置，和字串s2的j位置，能否组成合理的字串s3(i+j)...
 *          dp[i][j] = dp[i-1][j] 加一个字符 s3[i+j-1]过来，前提是 dp[i-1][j] = 1
 *          dp[i][j-1] 加一个字符 s3[i+j-1]过来，前提是 dp[i][j-1] = 1
 *          两者符合一个其中1个，dp[i][j] = 1， 否则就是 dp[i][j] = 0
 */
public class Leetcode98_InterleavingString {

    public static void main(String[] args) {
        System.out.println(isInterleave("", "", ""));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int p = s3.length();

        if (m + n != p) {
            return false;
        }

        if (s1.equals("") && s2.equals("") && s3.equals("")) {
            return true;
        }

        int[][] dp = new int[m + 1][n + 1];

        // 初始化第一列
        for (int i = 1; i <= m; i++) {
            if (i == 1) {
                if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
                    dp[i][0] = 1;
                }
            } else {
                if (dp[i - 1][0] > 0 && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                    dp[i][0] = 1;
                }
            }
        }

        // 初始化第一行
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                if (s3.charAt(i - 1) == s2.charAt(i - 1)) {
                    dp[0][i] = 1;
                }
            } else {
                if (dp[0][i - 1] > 0 && s2.charAt(i - 1) == s3.charAt(i - 1)) {
                    dp[0][i] = 1;
                }
            }
        }

        // 开始动态规划
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j] > 0) {
                    dp[i][j] = 1;
                }

                if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1] > 0) {
                    dp[i][j] = 1;
                }
            }
        }

        return dp[m][n] == 1;


    }
}

