package 二分查找;

/**
 * 执行结果：通过
 * 显示详情
 * 执行用时：1 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：37 MB, 在所有 Java 提交中击败了 5.55% 的用户
 */
public class x的平方根_easy_69 {

    public static void main(String[] args) {
        int ans = mySqrt(2147395599);
        System.out.println("ans=" + ans);
    }

    public static int mySqrt(int x) {
        int left = 1;
        int right = x / 2 + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 核心点：long 解决溢出
            long t = (long) mid * mid;

            if (t == x) {
                return mid;
            } else if (t < x) {
                left = mid + 1;
            } else if (t > x) {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
