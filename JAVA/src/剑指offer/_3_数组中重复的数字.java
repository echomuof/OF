package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/9/27
 */
public class _3_数组中重复的数字 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (cur != i) {
                if (cur == nums[cur]) {
                    return cur;
                }
                int tmp = nums[cur];
                nums[cur] = nums[i];
                nums[i] = tmp;
            }
        }
        return 0;
    }
}
