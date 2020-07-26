package 二分查找;

public class 找出所有行中最小公共元素_medium_1198 {

    public static void main(String[] args) {
        int ans = smallestCommonElement(new int[][]{{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}, {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}});
        System.out.println("ans=" + ans);
    }

    public static int smallestCommonElement(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[] isExistAll = new boolean[n];
        for (int i = 0; i < n; i++) {
            isExistAll[i] = true;
        }

        for (int col = 0; col < n; col++) {
            int target = mat[0][col];

            // 看能不能在 1至 n-1列找到一样的，全部都能找到，说明这是公共元素
            for (int i = 1; i < m; i++) {
                boolean b = binarySearch(mat[i], target);
                if (!b) {
                    isExistAll[col] = false;
                    break;
                }
            }

            // 最先找到的公共元素，就是最小公共元素
            if (isExistAll[col]) {
                return mat[0][col];
            }
        }
        return -1;
    }

    private static boolean binarySearch(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == target) {
                return true;
            } else if (target < row[mid]) {
                right = mid - 1;
            } else if (target > row[mid]) {
                left = mid + 1;
            }
        }
        return false;
    }
}
