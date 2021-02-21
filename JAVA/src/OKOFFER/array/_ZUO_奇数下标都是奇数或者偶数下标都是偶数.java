package OKOFFER.array;

/**
 * @author: wangdarui
 * @created: 2021/2/15
 */
public class _ZUO_奇数下标都是奇数或者偶数下标都是偶数 {
    public static void modify(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int ou = 0;
        int ji = 1;
        int end = nums.length - 1;
        while (ou < nums.length && ji < nums.length) {
            if (nums[end] % 2 == 0) {
                swap(nums, ou, end);
                ou += 2;
            } else {
                swap(nums, ji, end);
                ji += 2;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
