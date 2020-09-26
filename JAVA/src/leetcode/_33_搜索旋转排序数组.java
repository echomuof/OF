package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/27
 */
public class _33_搜索旋转排序数组 {
    public static void main(String[] args) {
        _33_搜索旋转排序数组 a = new _33_搜索旋转排序数组();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(a.search(nums, 0));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //左边有效，右边无序
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { //左边无序，右边有序
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
