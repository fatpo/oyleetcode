package 滑动窗口;

/**
 * Created by ouyang on 2020/7/15.
 */
public class 至多包含K个不同字符的最长子串_hard_340 {
    public static void main(String[] args) {
        int ans = lengthOfLongestSubstringKDistinct("eceba", 2);
        System.out.println("ans=" + ans);
        assert ans == 3;

        ans = lengthOfLongestSubstringKDistinct("aa", 1);
        System.out.println("ans=" + ans);
        assert ans == 2;

        ans = lengthOfLongestSubstringKDistinct("abaccc", 2);
        System.out.println("ans=" + ans);
        assert ans == 4;
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int right = 0;
        int needClassCnt = 0;
        int[] window = new int[128];

        int ans = 0;
        int validCnt = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            window[r]++;

            if (window[r] == 1) {
                needClassCnt++;
                validCnt++;

                // 如果在k窗口内，无脑选答案
                if (needClassCnt <= k) {
                    ans = Math.max(ans, validCnt);
                }

                // 种类超过k窗口，则收缩直到：第一个能完全被消除的种类
                while (needClassCnt > k) {
                    char l = s.charAt(left);
                    left++;
                    validCnt--;
                    window[l]--;
                    if (window[l] == 0) {
                        needClassCnt--;
                    }
                }
            } else {
                // 之前出现过的字符，无脑+1
                validCnt++;
                ans = Math.max(ans, validCnt);
            }
        }
        return ans;
    }
}
