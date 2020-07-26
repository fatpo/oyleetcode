package 二分查找;

public class 在排序数组中查找元素的第一个和最后一个位置_medium_34 {

    public static void main(String[] args) {
        int[] ans = searchRange(new int[]{3, 4, 5, 8, 8, 8, 10}, 8);
        System.out.println("ans=" + ans);
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //System.out.println(" "+left +" "+mid+" "+right);
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target == nums[mid]) {
                right = mid - 1;
            }
        }
        //System.out.println(" "+left +" "+right);
        // [0, -1]
        // [n, n-1]
        // [i, i-1]
        int ans1 = -1;
        if (left == nums.length && nums[left - 1] == target) {
            ans1 = nums.length - 1;
        } else if (right == -1 && nums[0] == target) {
            ans1 = 0;
        } else if (left < nums.length && nums[left] == target) {
            ans1 = left;
        }


        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target == nums[mid]) {
                left = mid + 1;
            }
        }
        // [0, -1]
        // [n, n-1]
        // [i+1, i]
        int ans2 = -1;
        if (left == nums.length && nums[left - 1] == target) {
            ans2 = nums.length - 1;
        } else if (right == -1 && nums[0] == target) {
            ans2 = 0;
        } else if (right >= 0 && nums[right] == target) {
            ans2 = left - 1;
        }

        return new int[]{ans1, ans2};
    }
}
