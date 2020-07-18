package 滑动窗口;

/**
 * Created by ouyang on 2020/7/15.
 */
public class 字符串的排列_567 {
    public static void main(String[] args) {
        boolean ans = checkInclusion("ab", "eidbaooo");
        System.out.println("ans=" + ans);
        assert ans;

        ans = checkInclusion("ab", "eidboaoo");
        System.out.println("ans=" + ans);
        assert !ans;
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] window = new int[128];
        int[] need = new int[128];

        // 先计算好需要的字符种类
        int needClassCnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (need[c] == 0) {
                needClassCnt++;
            }
            need[c]++;
        }

        int left = 0;
        int right = 0;
        int validClassCnt = 0;
        while (right < s2.length()) {
            char r = s2.charAt(right);
            right++;
            window[r]++;

            // 达到字符种类的条件，要++
            if (need[r] > 0 && need[r] == window[r]) {
                validClassCnt++;
            }

            // 一旦达到字符种类则说明满足条件，可退出
            if (validClassCnt == needClassCnt) {
                return true;
            } else {
                // 不断收缩窗口，保证整个windows长度 == s1长度-1
                // 以备下一次拼凑right的时候就是个完整的window了
                while (right - left >= s1.length()) {
                    char l = s2.charAt(left);

                    // 达到字符种类的条件的，被收缩后要--
                    if (need[l] > 0 && need[l] == window[l]) {
                        validClassCnt--;
                    }
                    window[l]--;
                    left++;
                }
            }
        }

        return false;
    }

}
