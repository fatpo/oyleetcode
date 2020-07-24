package 二分查找;

public class 猜数字大小_easy_374 {

    private static int target = 6;

    public static void main(String[] args) {
        int ans = guessNumber(6);
        System.out.println("ans=" + ans);
    }

    private static int guess(int n) {
        if (n == target) {
            return 0;
        }
        if (n > target) {
            return 1;
        }
        return -1;
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int haha = guess(mid);
            if (haha == 0) {
                return mid;
            } else if (haha == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

}
