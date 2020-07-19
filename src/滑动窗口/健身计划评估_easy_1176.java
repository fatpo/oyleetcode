package 滑动窗口;

/**
 * Created by ouyang on 2020/7/15.
 */
public class 健身计划评估_easy_1176 {
    public static void main(String[] args) {
        int ans = dietPlanPerformance(new int[]{1, 2, 3, 4, 5}, 1, 3, 3);
        System.out.println("ans=" + ans);
        assert ans == 0;

        ans = dietPlanPerformance(new int[]{11, 21, 31, 4, 5}, 1, 3, 3);
        System.out.println("ans=" + ans);
        assert ans == 5;
    }

    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int ans = 0;
        int validCnt = 0;
        int left = 0;
        int right = 0;
        while (right < calories.length) {
            validCnt += calories[right];
            right++;
            if (right - left == k) {
                if (validCnt < lower) {
                    ans--;
                } else if (validCnt > upper) {
                    ans++;
                }
                validCnt -= calories[left];
                left++;
            }
        }
        return ans;
    }

}
