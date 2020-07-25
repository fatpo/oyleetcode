package 不知如何分类;

import java.util.ArrayList;
import java.util.List;

public class 有序矩阵中第K小的元素_medium_378 {

    public static void main(String[] args) {
        int ans = kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8);
        System.out.println("ans=" + 1);
        assert ans == 13;
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        // 记录每一行的指针
        int[] pp = new int[n];

        int k1 = 0;
        while (k1 < k) {
            List<Integer> t = getMinIndex(matrix, pp);
            k1 += t.size();
            if (k1 >= k) {
                for (int index : t) {
                    int pj = pp[index];
                    return matrix[index][pj];
                }
            } else {
                for (int index : t) {
                    pp[index]++;
                }
            }
        }

        return 0;
    }

    private static List<Integer> getMinIndex(int[][] matrix, int[] pp) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < pp.length; i++) {
            int pi = pp[i];
            if (pi == pp.length) continue;

            if (matrix[i][pi] < min) {
                min = matrix[i][pi];
                minIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int target = matrix[minIndex][pp[minIndex]];
        for (int i = 0; i < pp.length; i++) {
            int pj = pp[i];
            if (pj == pp.length) continue;
            if (matrix[i][pj] == target) {
                ans.add(i);
            }
        }
        return ans;
    }
}
