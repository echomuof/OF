package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/27
 */
public class _153_寻找旋转数组中的最小值 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[l] <= nums[mid]) {
                minNum = Math.min(minNum, nums[l]);
                l = mid + 1;
            } else {
                minNum = Math.min(minNum, nums[r]);
                r = mid;
            }
        }
        return minNum;
    }
}
