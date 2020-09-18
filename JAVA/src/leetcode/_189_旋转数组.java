package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/16
 */
public class _189_旋转数组 {
    public static void main(String[] args) {
        int[] arr = {-1};
        rotate(arr, 2);
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
}
