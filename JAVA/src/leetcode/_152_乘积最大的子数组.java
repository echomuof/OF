package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/10/21
 */
public class _152_乘积最大的子数组 {
    public int maxProduct(int[] nums) {
        int ans = 1;
        int head = nums[0];
        for (int num : nums) {
            head = Math.max(num, num * head);
            ans = Math.max(ans, ans * head);
        }
        return ans;
    }
}
