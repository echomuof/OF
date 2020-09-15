package java_leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/15
 */
public class _26_删除排序数组中的重复项 {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
