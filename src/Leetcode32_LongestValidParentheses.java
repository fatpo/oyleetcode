/*
32. Longest Valid Parentheses
Hard

1785

86

Favorite

Share
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"


这道题依旧是动态规划，但是比较绕....

dp[i] 表示第i个元素这里，能够达到的连续最长长度。

比如：(()((()))，遇到( 直接就是dp[i] = 0，
遇到)如果符合括号对的两种i情况，则dp[i] = dp[i-1] + 1:
    1、() 这种，dp[0] = 0 , dp[1] = 0 + 1 = 1
    2、(()) 这种，dp[0] = 0, dp[1] = 0, dp[2] = 1(符合面对面，dp[2]=dp[1]+1=1), dp[2] = 2(符合隔空相对，dp[2]=dp[1]+1=2)
那么，(()((())) 就翻译成：0 0 1 0 0 0 1 2 3
上面的步骤只能算是预处理，还要把相邻的有效括号组加起来，比如：
    第1-2个元素：()算第一组
    第3-8个元素：((()))算第二组
他们是相邻，所以dp值可以加起来。。。
max = dp[2] + dp[8] = 1 + 3 = 4，因为返回值是不是括号对，是括号数，所以 * 2 = 8...

ps: 严格上来说都不算是动态规划，因为dp某些元素，不是当前最长长度。


 * */

public class Leetcode32_LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()(((("));
        System.out.println(longestValidParentheses("()("));
        System.out.println(longestValidParentheses(")()("));
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses("()(((((()()()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses("())))))))))))"));
        System.out.println(longestValidParentheses("(())))()()()()"));
        System.out.println(longestValidParentheses("(()))((((())"));
        System.out.println(longestValidParentheses("(()(((()"));
        System.out.println(longestValidParentheses("(()((()))"));
    }

    public static int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }

        int dp[] = new int[s.length()];

        // 初始化
        dp[0] = 0;
        int maxNum = 0;

        // 动态规划
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else if (s.charAt(i) == ')') {
                // dp[i]+1，条件1：括号面对面，如：()
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 1] + 1;

                    // 如果上一组()靠着本组括号对，则加起来
                    if (i - dp[i] * 2 >= 0 && s.charAt(i - dp[i] * 2) == ')') {
                        dp[i] += dp[i - dp[i] * 2];
                    }
                }

                // dp[i]+1，条件2：括号远程对面对，中间隔了括号对，如：(())
                else if (i - (dp[i - 1] + 1) * 2 + 1 >= 0 && s.charAt(i - (dp[i - 1] + 1) * 2 + 1) == '(') {
                    dp[i] = dp[i - 1] + 1;

                    // 如果上一组()靠着本组括号对，则加起来
                    if (i - dp[i] * 2 >= 0 && s.charAt(i - dp[i] * 2) == ')') {
                        dp[i] += dp[i - dp[i] * 2];
                    }
                }

            }

            maxNum = Math.max(maxNum, dp[i]);
        }

        // 返回括号数，不是括号对，所以 * 2
        return maxNum * 2;
    }
}