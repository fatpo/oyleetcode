package 滑动窗口;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ouyang on 2020/7/15.
 */
public class 滑动窗口最大值_hard_239 {
    public static void main(String[] args) {
        int[] ans = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println("ans=" + ans);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 && k == 0) return new int[]{};

        int[] ans = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        Deque<Integer> queue = new LinkedList<>();

        while (right < nums.length) {
            int r = nums[right];

            // 维护双头队列，从左到右，从大到小
            while (!queue.isEmpty() && nums[queue.peekLast()] <= r) {
                queue.pollLast();
            }
            queue.addLast(right);

            // 每次拿队列的左边即可，如果队列左边超过window范围则剔除
            if (right - left + 1 == k) {
                ans[left++] = nums[queue.peekFirst()];
                if (queue.peekFirst() < left) {
                    queue.pollFirst();
                }
            }
            right++;
        }
        return ans;
    }

}
