package 不知如何分类;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 归并排序的思维，不过归并排序是归 2 个数组，我们要归 n 个数组，需要用优先队列来辅助
 * 执行结果：通过
 * 显示详情
 * 执行用时：24 ms, 在所有 Java 提交中击败了 22.95% 的用户
 * 内存消耗：45.5 MB, 在所有 Java 提交中击败了 7.69% 的用户
 */
public class 有序矩阵中第K小的元素_medium_378 {

    public static void main(String[] args) {
        int ans = kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8);
        System.out.println("ans=" + 1);
        assert ans == 13;
    }


    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(matrix.length, new HahaComparator());

        for (int i = 0; i < matrix.length; i++) {
            queue.offer(new int[]{matrix[i][0], i, 0});
        }

        int k1 = 1;
        int num = 0;
        while (k1 <= k) {
            int[] node = queue.poll();
            if (node != null) {
                num = node[0];
                int row = node[1];
                int col = node[2];
                //System.out.println("k1:"+k1+",row:"+row+",col:"+col+",num:"+num);
                if (col + 1 <= matrix.length - 1) {
                    queue.add(new int[]{matrix[row][col + 1], row, col + 1});
                }
            }
            k1++;
        }
        return num;
    }


    static class HahaComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }


}
