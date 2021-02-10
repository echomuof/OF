package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/16
 */
public class _189_旋转数组 {
    public static void main(String[] args) {
        int[] arr = {-1};
        // rotate(arr, 2);
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(getMinLenArr(nums, 7));
    }

    public static void rotate(int[] nums, int k) {
        int[] help = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            help[(i + k) % help.length] = nums[i];
        }
        for (int i = 0; i < help.length; i++) {
            nums[i] = help[i];
        }
    }


    public static int getMinLenArr(int[] nums, int s) {
        int sum = 0;
        int n1 = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                minLen = Math.min(minLen, i - n1 + 1);
                sum -= nums[n1++];
            }
        }
        return minLen;
    }


    public int minSubArrayLen(int s, int[] nums) {
        boolean flag = true;
        int minOfLength = s;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= s) {
                flag = false;
                if (i - left + 1 < minOfLength) {
                    minOfLength = i - left + 1;
                }
                sum -= nums[left];
                left++;
            }
        }
        if (flag) return 0;
        return minOfLength;
    }
}
