package 滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ouyang on 2020/7/15.
 */
public class 无重复字符的最长子串_3 {
    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("abcabcbb");
        System.out.println("ans=" + ans);
        assert ans == 3;

        ans = lengthOfLongestSubstring("bbbbb");
        System.out.println("ans=" + ans);
        assert ans == 1;

        ans = lengthOfLongestSubstring("pwwkew");
        System.out.println("ans=" + ans);
        assert ans == 3;

        ans = lengthOfLongestSubstring("");
        System.out.println("ans=" + ans);
        assert ans == 0;

        ans = lengthOfLongestSubstring("dvdf");
        System.out.println("ans=" + ans);
        assert ans == 3;

        ans = lengthOfLongestSubstring("aaaaaaabbbbbbbb");
        System.out.println("ans=" + ans);
        assert ans == 2;

        ans = lengthOfLongestSubstring("tmmzuxt");
        System.out.println("ans=" + ans);
        assert ans == 5;
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] window = new int[128];
        int left = 0;
        int right = 0;
        int ans = 0;
        int validCnt = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            window[r]++;

            // 遇到重复的无脑+1且更新答案
            if (window[r] == 1) {
                validCnt++;
                ans = Math.max(ans, validCnt);
            } else {
                // 不断缩小窗口，直到找到那个重复的点
                while (window[s.charAt(left)] != 2) {
                    window[s.charAt(left)]--;
                    left++;
                }
                window[s.charAt(left)]--;
                left++;

                // 更新答案
                validCnt = right - left + 1;
                ans = Math.max(ans, validCnt);
            }

            // 考察下一个right
            right++;
        }
        return ans;
    }

}