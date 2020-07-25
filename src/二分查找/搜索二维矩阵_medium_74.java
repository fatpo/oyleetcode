package 二分查找;

/**
 * 执行结果：通过
 * 显示详情
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了 94.29% 的用户
 */
public class 搜索二维矩阵_medium_74 {

    public static void main(String[] args) {
        boolean ans = searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3);
        System.out.println("ans=" + ans);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        // 先确定在哪一行
        int left = 0;
        int right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][n - 1] == target) {
                return true;
            } else if (matrix[mid][n - 1] < target) {
                left = mid + 1;
            } else if (matrix[mid][n - 1] > target) {
                right = mid - 1;
            }
        }

        // [left, right]都是闭区间，推出 while 的条件是 left > right
        // 极端情况，可能right 一直往左压缩， [0, -1]，此时 row = 0
        // 极端情况，可能left 一直往右压缩 [m, m-1]， 此时 row = m-1
        // 正常情况, row = left - 1 同时 row = right
        int row = -1;
        if (right <= -1) {
            row = 0;
        } else if (left >= m) {
            row = m - 1;
        } else {
            row = left - 1;
        }

        // 如果 row 所在行最大的小于 target，row ++， 加到边界外就 return false
        if (matrix[row][n - 1] < target) {
            row++;
        }
        if (row >= m) return false;


        // 再确定在哪一列: 普通的 2 分查找，不需要考虑边界，找不到就直接 false
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            }
        }
        return false;

    }
}
