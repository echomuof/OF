package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/10/13
 */
public class _42_连续子数组的最大和 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(num, sum + num);
            max = Math.max(max, sum);
        }
        return max;
    }
}
