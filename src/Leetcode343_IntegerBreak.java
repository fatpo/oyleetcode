/*
343. Integer Break
Medium

569

166

Favorite

Share
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
Note: You may assume that n is not less than 2 and not larger than 58.

这道题可以用动态规划做，但是本质上还是数学问题。

>=4 的数都可以用2+3来替代，所以这道题要比较 2，3 这2个数做底数，然后 n/2, n/3 做指数，求最大。

f(x) = x^(n/x)，求 f(x) 最大的时候， x是什么？
两边同时取ln, ln f(x) = ln x^(n/x) = (n/x) lnx
所以取fx(x)最大值的问题 -> 取 lnf(x) 最大值的问题 -> (n/x) lnx 最大值的问题。

1、取极值问题，先求导，看看存不存在极值？
    g = (n/x) lnx
    g' = -n/(x^2)lnx + n/x * 1/x = (lnx-1) * n/x^2
    让g' = 0 = (lnx-1) * n/x^2 ，因为x>0,n>0, 那么只能是 lnx-1 == 0 ，那么x == e。
    所以存在极大值，且这个极大值在e达到最大点。

2、问题变成了 f(2) 和 f(3) 谁大谁小。
    f(2) = 2^(n/2)
    f(3) = 3^(n/3)
    f(4) = 4
    上下两式同时取ln:
    lnf(2) = ln (2^(n/2)) = n/2 * ln2  = n/6 * 3ln2  =  n/6 * ln8
    lnf(3) = ln (3^(n/3)) = n/3 * ln3  = n/6 * 2ln3  =  n/6 * ln9
    明显lnf(3)更大，所以f(3) 更大。


 * */

public class Leetcode343_IntegerBreak {

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
        System.out.println(integerBreak(36));
    }

    /**
     * 数学方法，尽可能拿到3做底数，不行就用2来凑。
     * 比如10，尽可能用3作为底数 = 3 + 3 + 3 + 1，但是因为最后一个1太小了，至少要2。所以3退一个 = 3 + 3 + 2 + 2.
     * 比如8，尽可能用3作为底数 = 3 + 3 + 2.
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int a = n / 3; // 3的个数
        int b = n % 3;
        int c = 0; // 2的个数
        if (b == 1) {
            a -= 1;
            c = 2;
        } else if (b == 2) {
            c = 1;
        }
        if (c >= 1) {
            return (int) Math.pow(3, a) * (int) (Math.pow(2, c));
        } else {
            return (int) Math.pow(3, a);
        }

    }


    /**
     * 动态规划做法，但是本质上还是数学问题！
     *
     * @param n
     * @return
     */
    public int integerBreak2(int n) {
        int[] res = new int[n + 1];
        res[1] = 1;
        // For numbers from 2 to 6
        for (int i = 2; i <= 6 && i <= n; i++) {
            res[i] = (int) i / 2 * (i - (int) i / 2);
        }
        // For numbers larger than 6, apply DP.
        for (int i = 7; i <= n; i++) {
            res[i] = Math.max(res[i - 2] * 2, res[i - 3] * 3);
        }
        return res[n];
    }

}