package leetcode;

/**
 * @author: wangdarui
 * @date: 2020/9/21
 */
public class _169_多数元素 {
    public static void main(String[] args) {
        _169_多数元素 a = new _169_多数元素();
        System.out.println(a.majorityElement(new int[]{3, 2, 3}));
    }

    public int majorityElement(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    public int process(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = low + (high - low) / 2;
        int left = process(nums, low, mid);
        int right = process(nums, mid + 1, high);
        if (left == right) return left;
        int l = count(nums, left, low, mid);
        int r = count(nums, right, mid + 1, high);
        return l > r ? left : right;
    }

    public int count(int[] nums, int target, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == target) count++;
        }
        return count;
    }
}
