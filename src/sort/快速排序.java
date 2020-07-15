package sort;

/**
 * Created by ouyang on 2020/7/14.
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 2, 4, 6, 8, 10, 0, 9, 7, 11};
        quicksort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.printf(" " + num);
        }
        System.out.println();
    }

    private static void quicksort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = partition(nums, left, right);
            System.out.println("left: " + left + ", right: " + right + ", mid:" + mid);
            quicksort(nums, left, mid - 1);
            quicksort(nums, mid + 1, right);
        }

    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    private static int partition(int[] nums, int p, int r) {
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (nums[j] <= x) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }
}
