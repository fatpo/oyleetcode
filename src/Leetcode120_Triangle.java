import java.util.ArrayList;
import java.util.List;

/*
120. Triangle
Medium

1070

117

Favorite

Share
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

数塔问题，寻找从上至下，经过的最短路径。
数塔问题，从上至下分析，从下至上求解。

dp[i][j] = max {
                    dp[i+1][j],
                    dp[i+1][j+1]
                } + s[i][j]



* */
public class Leetcode120_Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>(); //定义Integer泛型
        List<Integer> alist = new ArrayList<Integer>(); //定义Integer泛型
        List<Integer> blist = new ArrayList<Integer>(); //定义Integer泛型
        List<Integer> clist = new ArrayList<Integer>(); //定义Integer泛型
        List<Integer> dlist = new ArrayList<Integer>(); //定义Integer泛型

        alist.add(2);

        blist.add(3);
        blist.add(4);

        clist.add(6);
        clist.add(5);
        clist.add(7);

        dlist.add(4);
        dlist.add(1);
        dlist.add(8);
        dlist.add(3);

        triangle.add(alist);
        triangle.add(blist);
        triangle.add(clist);
        triangle.add(dlist);
        System.out.println(minimumTotal(triangle));
    }


    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty() || triangle.get(0).isEmpty()) {
            return 0;
        }

        int dp[][] = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];

        // 初始化最底层
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }

        // 由下往上，动态规划
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }
}
