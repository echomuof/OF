package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/15
 */
public class _ZUO_计算数组的小和 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 4, 6};
        System.out.println(getSmallSum(nums));
    }

    public static int getSmallSum(int[] nums) {
        return func(nums, 0, nums.length - 1);
    }

    public static int func(int[] nums, int L, int R) {
        if (L == R) return 0;
        int M = L + (R - L) / 2;
        return func(nums, L, M) + func(nums, M + 1, R) + merge(nums, L, M, R);
    }

    public static int merge(int[] nums, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int l1 = L;
        int l2 = M + 1;
        int i = 0;
        int smallSum = 0;
        while (l1 <= M && l2 <= R) {
            if (nums[l1] <= nums[l2]) {
                smallSum += nums[l1] * (R - l2 + 1);
                help[i++] = nums[l1++];
            } else {
                help[i++] = nums[l2++];
            }
        }
        while (l1 <= M) {
            help[i++] = nums[l1++];
        }
        while (l2 <= R) {
            help[i++] = nums[l2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[L + j] = help[j];
        }
        return smallSum;
    }

}
