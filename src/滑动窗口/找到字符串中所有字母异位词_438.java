package 滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ouyang on 2020/7/15.
 */
public class 找到字符串中所有字母异位词_438 {
    public static void main(String[] args) {
        System.out.println("#############################");
        List<Integer> ans = findAnagrams("ababababab", "aab");
        System.out.println("ans=" + ans);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] window = new int[128];
        int[] need = new int[128];
        int needCnt = 0;
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i)]++;
            needCnt++;
        }

        // 初始化窗口，p除了最后一个字节都要考察
        for (int i = 0; i < p.length() - 1; i++) {
            char ch = s.charAt(i);
            window[ch]++;
            if (need[ch] > 0 && need[ch] >= window[ch]) {
                cnt++;
            }
        }

        int left = 0;
        int right = p.length() - 1;

        List<Integer> ans = new ArrayList<>();
        while (right < s.length()) {
            // 考察right字符
            char rightCh = s.charAt(right);
            window[rightCh]++;
            if (need[rightCh] > 0 && need[rightCh] >= window[rightCh]) {
                cnt++;
            }

            // 窗口符合条件直接加到结果集
            if (cnt == needCnt) {
                ans.add(left);
                char leftCh = s.charAt(left);
                window[leftCh]--;

                // 加完结果后left，right 双双+1，因为放弃left，所以cnt-=1
                left++;
                right++;
                cnt--;
            } else {
                // 如果left是个有价值的，放弃left需要cnt-=1
                char leftCh = s.charAt(left);
                if (need[leftCh] > 0 && window[leftCh] <= need[leftCh]) {
                    cnt--;
                }
                // left，right 双双+1
                window[leftCh]--;
                left++;
                right++;
            }
        }
        return ans;
    }

}