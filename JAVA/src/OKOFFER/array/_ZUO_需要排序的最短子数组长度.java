package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _ZUO_需要排序的最短子数组长度 {

    public static int getMinSortLength(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int noMinIndex = -1;
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > min) {
                noMinIndex = i;
            } else {
                min = nums[i];
            }
        }
        if (noMinIndex == -1) return 0;
        int noMaxIndex = -1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) {
                noMaxIndex = i;
            } else {
                max = nums[i];
            }
        }
        return noMaxIndex - noMinIndex + 1;
    }

}
