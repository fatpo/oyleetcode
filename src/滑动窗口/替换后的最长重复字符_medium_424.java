package 滑动窗口;

/**
 * Created by ouyang on 2020/7/15.
 *
 * 执行结果：通过
 * 显示详情
 * 执行用时：5 ms , 在所有 Java 提交中击败了 93.08% 的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了 100.00% 的用户
 */
public class 替换后的最长重复字符_medium_424 {
    public static void main(String[] args) {
        int ans = characterReplacement("ABABCCCCCCC", 2);
        System.out.println("ans=" + ans);
        assert ans == 9;

        ans = characterReplacement("ABAB", 2);
        System.out.println("ans=" + ans);
        assert ans == 4;

        ans = characterReplacement("AAAA", 2);
        System.out.println("ans=" + ans);
        assert ans == 4;

        ans = characterReplacement("ABCD", 2);
        System.out.println("ans=" + ans);
        assert ans == 3;

        ans = characterReplacement("ABCDDEDD", 2);
        System.out.println("ans=" + ans);
        assert ans == 6;
    }


    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int ans = 0;
        int[] window = new int[26];
        int windowMax = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            window[r - 'A']++;
            windowMax = Math.max(windowMax, window[r - 'A']);

            // 在k的庇护下，无脑+1
            if (right <= k) {
                ans = Math.max(ans, right - left);
                continue;
            }

            // 在k的庇护下 配合最大的窗口值，无脑+1
            if (windowMax + k >= right - left) {
                ans = Math.max(ans, right - left);
                continue;
            }

            // 这里我们不需要更新这个最大窗口值，只约束这个窗口大小不要超过历史最大就行
            // 反正答案也不会从这个收缩后的窗口中找
            while (windowMax + k < right - left) {
                char l = s.charAt(left);
                left++;
                window[l - 'A']--;
            }
        }
        return ans;
    }


}
