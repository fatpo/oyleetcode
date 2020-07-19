package 滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ouyang on 2020/7/15.
 */
public class 找到字符串中所有字母异位词_medium_438 {
    public static void main(String[] args) {
        List<Integer> ans = findAnagrams("ababababab", "aab");
        System.out.println("ans=" + ans);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] window = new int[128];
        int[] need = new int[128];

        // needClassCnt 表示需要的种类cnt
        int needClassCnt = 0;
        for (int i = 0; i < p.length(); i++) {
            if (need[p.charAt(i)] == 0) {
                needClassCnt++;
            }
            need[p.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int validClassCnt = 0;
        List<Integer> ans = new ArrayList<>();
        while (right < s.length()) {
            // 处理r的数据
            char r = s.charAt(right);
            right++;
            if (need[r] > 0) {
                window[r]++;
                if (need[r] == window[r]) {
                    validClassCnt++;
                }
            }

            // 定长窗口看p的长度收缩
            while (right - left >= p.length()) {
                // 符合条件的添加ans
                if (validClassCnt == needClassCnt) {
                    ans.add(left);
                }

                // 对称处理l的数据
                char l = s.charAt(left);
                if (need[l] > 0) {
                    if (need[l] == window[l]) {
                        validClassCnt--;
                    }
                    window[l]--;
                }
                left++;
            }
        }
        return ans;
    }

}