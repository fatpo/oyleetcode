package 滑动窗口;

/**
 * Created by ouyang on 2020/7/15.
 */
public class 最大连续1的个数III_medium_1004 {
    public static void main(String[] args) {
        int ans = longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        System.out.println("ans=" + ans);
        assert ans == 6;

        ans = longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
        System.out.println("ans=" + ans);
        assert ans == 10;
    }

    public static int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;

        int ans = 0;
        int validCnt = 0;
        int kCnt = 0;
        while (right < A.length) {
            int r = A[right];
            right++;

            // 逢1无脑加
            if (r == 1) {
                validCnt++;
                ans = Math.max(ans, validCnt);
                continue;
            }

            // k值够无脑加
            if (kCnt < K) {
                kCnt++;
                validCnt++;
                ans = Math.max(ans, validCnt);
                continue;
            }

            // 放弃最左边的第一个0
            while (A[left] != 0) {
                validCnt--;
                left++;
            }
            left++;

            // 去掉第一个0 left
            validCnt--;
            kCnt--;

            // 当前right加入
            validCnt++;
            kCnt++;
        }
        return ans;
    }
}
