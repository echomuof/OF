package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/10/14
 */
public class _51_数组中的逆序对 {
    public static void main(String[] args) {
        _51_数组中的逆序对 a = new _51_数组中的逆序对();
        int[] nums = {7, 5, 6, 4};
        System.out.println(a.reversePairs(nums));
        System.out.println();
    }

    public int reversePairs(int[] nums) {
        if (nums.length==0) return 0;
        return process(nums, 0, nums.length - 1);
    }

    public int process(int[] nums, int L, int R) {
        if (L == R) return 0;
        int m = L + (R - L) / 2;
        int lcount = process(nums, L, m);
        int rcount = process(nums, m + 1, R);
        if (nums[m] <= nums[m + 1]) return lcount + rcount;
        return lcount + rcount + merge(nums, L, R, m);
    }

    public int merge(int[] nums, int L, int R, int m) {
        int count = 0;
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= R) {
            if (nums[p1] <= nums[p2]) {
                help[i++] = nums[p1++];
            } else {
                help[i++] = nums[p2++];
                count += m - p1 + 1;
            }
        }
        while (p1 <= m) help[i++] = nums[p1++];
        while (p2 <= R) help[i++] = nums[p2++];
        for (int j = 0; j < help.length; j++) {
            nums[L + j] = help[j];
        }
        return count;
    }
}
