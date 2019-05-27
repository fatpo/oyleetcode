/**
 * Created by ouyang on 2019/5/27.
 *
 *
 * 这道题和 132. Palindrome Partitioning II 思路非常相似
 * 只需要132题目的第一步就能完成啦：判断回文子串。
 *
 * 然后记录最长的回文子串即可。
 *
 * 回文子串判断：
 *      hw[j][i]表示是从j到i的子串是否是回文串。
 *      满足以下2个条件可以判断为true：
 *          1、s[j] == s[i] &&  hw[j+1][i-1] == true。 意思是如果我的首尾相等，并且我的子串是回文，那么我就是回文。
 *          2、s[j] == s[i] && j+1 > i-1。意思是 j == i 或者 j+1 == i，要么同一个字符，要么是相邻字符串相等，那么我就是回文。
 *
 */
public class Leetcode5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }

        boolean[][] hw = new boolean[n][n];
        int startPos = 0;
        int endPos = 0;
        int maxNum = -1;

        // 开始动态规划
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || hw[j + 1][i - 1])) {
                    hw[j][i] = true;

                    // 判断是否是最长的
                    if (maxNum < i - j + 1) {
                        maxNum = i - j + 1;
                        startPos = j;
                        endPos = i;
                    }
                }
            }

        }

        return s.substring(startPos, endPos + 1);
    }
}

