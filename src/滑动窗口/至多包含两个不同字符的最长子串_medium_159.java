package 滑动窗口;

/**
 * 执行结果：通过
 * 显示详情
 * 执行用时：1 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38 MB, 在所有 Java 提交中击败了 100.00% 的用户
 * <p>
 * Created by ouyang on 2020/7/15.
 */
public class 至多包含两个不同字符的最长子串_medium_159 {
    public static void main(String[] args) {
        int ans = lengthOfLongestSubstringTwoDistinct("abcedfg");
        System.out.println("ans=" + ans);
        assert ans == 2;

        ans = lengthOfLongestSubstringTwoDistinct("aaaaa");
        System.out.println("ans=" + ans);
        assert ans == 5;
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;
        int charClassCnt = 0;
        int[] window = new int[128];

        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            window[r]++;
            if (window[r] == 1) {
                charClassCnt++;
            }

            // 窗口伸展
            if (charClassCnt <= 2) {
                ans = Math.max(ans, right - left);
                continue;
            }

            //窗口收缩
            while (charClassCnt > 2) {
                char l = s.charAt(left);
                left++;
                window[l]--;
                if (window[l] == 0) {
                    charClassCnt--;
                }
            }
        }
        return ans;

    }

}
