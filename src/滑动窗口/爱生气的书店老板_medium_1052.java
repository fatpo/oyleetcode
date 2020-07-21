package 滑动窗口;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ouyang on 2020/7/15.
 */
public class 爱生气的书店老板_medium_1052 {
    public static void main(String[] args) {
        int ans = maxSatisfied(new int[]{4, 10, 10}, new int[]{1, 1, 0}, 2);
        System.out.println("ans=" + ans);
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int left = 0;
        int right = 0;

        // 窗口中收益最大的情绪值
        int windowMax = 0;
        int windowCnt = 0;

        int total = 0;
        while (right < customers.length) {
            int r = customers[right];
            int gr = grumpy[right];
            right++;

            // 记录下不被干扰的，应得的情绪值
            if (gr == 0) {
                total += r;
            }

            if (gr == 1) {
                windowCnt += r;
            }

            if (right <= X) {
                windowMax = windowCnt;
            } else {
                // 收缩窗口，维护最大窗口值
                if (grumpy[left] == 1) {
                    windowCnt -= customers[left];
                }
                left++;
                windowMax = Math.max(windowCnt, windowMax);
            }
        }
        return total + windowMax;
    }

}
