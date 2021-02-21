package OKOFFER.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wangdarui
 * @created: 2021/2/14
 */
public class _ZUO_不重复打印排序数组中相加和为给定值的所有二元组和三元组 {

    public static void main(String[] args) {
        int[] nums = {-8, -4, -3, 0, 1, 2, 4, 5, 8, 8, 9};
        getTwo(nums, 10);
        System.out.println();

        int[] nums3 = {-8, -4, -3, 0, 1, 2, 4, 5, 8, 9};
        getThree(nums3, 10);
    }

    public static void getTwo(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int target = k - num;
            if (set.contains(target)) {
                System.out.println(num + " " + target);
                set.remove(target);
            } else {
                set.add(num);
            }
        }
    }

    public static void getThree(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            set.add(a);
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                int target = k - a - b;
                if (set.contains(target)) {
                    System.out.println(a + " " + b + " " + target);
                    set.remove(a);
                    set.remove(b);
                    set.remove(target);
                } else {
                    set.add(b);
                }
            }
        }
    }
}
