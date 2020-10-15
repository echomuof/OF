package 剑指offer;

import javax.swing.plaf.IconUIResource;

/**
 * @author: wangdarui
 * @created: 2020/10/15
 */
public class _53_在排序数组中查找数字I {
    public static void main(String[] args) {
        _53_在排序数组中查找数字I a = new _53_在排序数组中查找数字I();
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(a.search(nums, 8));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) return 0;
        int index = binarySearch(nums, target);
        if (index == -1) return 0;
        int l = index;
        int r = index;
        int ans = 0;
        while (l >= 0) {
            if (nums[l] == nums[index]) {
                l--;
                ans++;
            } else {
                break;
            }
        }
        while (r < nums.length) {
            if (nums[r] == nums[index]) {
                r++;
                ans++;
            } else {
                break;
            }
        }
        return ans - 1;
    }

    public int binarySearch(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int M = L + (R - L) / 2;
            if (target == nums[M]) return M;
            else if (target < nums[M]) R = M - 1;
            else L = M + 1;
        }
        return -1;
    }

}
