/*
*
55. Jump Game
Medium

1842

190

Favorite

Share
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.


动态规划：
    dp[i] 表示当前能跳的最远距离...
    可能从2个状态过来:
        1、dp[i-1]，它本来就可以跳很远了，我就用它。比如[100, 2]，dp[0]就能跳100步啦...
        2、nums[i] + i，当前格子+最远能跳的格子，比如[100, 2]，nums[1]+1=2，最远能跳到第3个格子...
        3、取上面1和2最大的作为dp[i]的最远距离.

    dp[i] = Math.max(dp[i - 1], i + nums[i]);


*
*
* */

public class Leetcode55_JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 2, 3}));
        System.out.println(canJump(new int[]{1, 2, 3, 4}));
        System.out.println(canJump(new int[]{2, 1, 3, 4, 1, 2, 1, 5, 4}));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        // 如果只有一格，那么已经成功
        if (nums.length == 1) {
            return true;
        }

        // 初始化
        int dp[] = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 如果当前格子可达
            if (dp[i - 1] >= i) {
                dp[i] = Math.max(dp[i - 1], i + nums[i]);
            }
            // 如果已经达到条件，直接返回true
            if (dp[i] >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
