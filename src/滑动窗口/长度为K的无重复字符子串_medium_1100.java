package 滑动窗口;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ouyang on 2020/7/15.
 */
public class 长度为K的无重复字符子串_medium_1100 {
    public static void main(String[] args) {
        int ans = numKLenSubstrNoRepeats("havefunonleetcode", 5);
        System.out.println("ans=" + ans);
        assert ans == 6;

        ans = numKLenSubstrNoRepeats("home", 5);
        System.out.println("ans=" + ans);
        assert ans == 0;
    }

    public static int numKLenSubstrNoRepeats(String S, int K) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int[] window = new int[128];

        int validCnt = 0;
        while (right < S.length()) {
            char r = S.charAt(right);
            right++;
            window[r]++;
            if (window[r] == 1) {
                validCnt++;

                // 窗口满足条件，则记录答案
                if (validCnt == K) {
                    ans++;
                    int l = S.charAt(left);
                    window[l]--;
                    left++;
                    validCnt--;
                }
            } else {
                // 找到重复的那个点，left 到这个点的数据都要处理
                while (window[S.charAt(left)] != 2) {
                    window[S.charAt(left)]--;
                    left++;
                    validCnt--;
                }
                window[S.charAt(left)]--;
                left++;
            }
        }

        return ans;
    }
}
