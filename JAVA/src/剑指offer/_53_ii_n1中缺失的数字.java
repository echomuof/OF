package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/10/15
 */
public class _53_ii_n1中缺失的数字 {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m]==m) l = m + 1;
            else r = m - 1;
        }
        return l;
    }
}
