package OKOFFER.array;

import com.sun.jmx.snmp.SnmpNull;

/**
 * @author: wangdarui
 * @created: 2021/2/15
 */
public class _ZUO_在数组中找到一个局部最小的位置 {
    public static int getGroupMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1 || nums[0] < nums[1]) return 0;
        if (nums[nums.length - 2] > nums[nums.length - 1]) return nums.length - 1;
        int l = 1;
        int r = nums.length - 2;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid - 1]) {
                r = mid - 1;
            } else if (nums[mid] > nums[mid + 1]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
