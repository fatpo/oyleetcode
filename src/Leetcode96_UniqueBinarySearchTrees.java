/*
96. Unique Binary Search Trees
Medium

1655

65

Favorite

Share
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


这道题依旧是动态规划，哎。

dp[i] = dp[i-1] + dp[i-1] + xxxx
     1、先说为啥是2个dp[i-1]，那是因为最左最右2个结点作为root，剩下的就变成i-1个结点有多少个情况，共2种情况。
        考虑的依旧是i-1个结点能组成多少颗BST，所以是 dp[i-1] + dp[i-1].

     2、xxxx这个就是国哥没考虑到的，借鉴了别人的思路，觉得非常有道理。
        继承第一点的思考，如果我们选择某一个中间结点作为root，那么考虑的问题就切割成root左边有多少个子树a，右边有多少个子树b。
        xxxx = 左边a x 右边 b。

     3、继续第二点的思考，如果一共有5个结点，1,2,3,4,5，
         3.1 我们可以选择2作为root， 那么左边子树 = dp(1)，右边子树 = dp(3)
         3.2 我们可以选择3作为root， 那么左边子树 = dp(2)，右边子树 = dp(2)
         3.3 我们可以选择4作为root， 那么左边子树 = dp(3)，右边子树 = dp(1)

     4、那么dp[5] = dp[4] + dp[4] + 中间结点xxxx
                 = dp[4] + dp[4] + (dp[1] * dp[3] + dp[2] * dp[2] + dp[3] * dp[1])

 * */

public class Leetcode96_UniqueBinarySearchTrees {

    public static void main(String[] args) {
        System.out.println(numTrees(4));
        System.out.println(numTrees(5));
        System.out.println(numTrees(6));
        System.out.println(numTrees(7));
    }

    public static int numTrees(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
}