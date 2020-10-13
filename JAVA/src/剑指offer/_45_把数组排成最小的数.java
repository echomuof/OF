package 剑指offer;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2020/10/13
 */
public class _45_把数组排成最小的数 {
    public static void main(String[] args) {
        _45_把数组排成最小的数 a = new _45_把数组排成最小的数();
        int[] nums = {999999998, 999999997, 999999999};
        System.out.println(a.minNumber(nums));
    }


    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        String ans = "";
        for (String str : strs) {
            ans += str;
        }
        return ans;
    }
}
