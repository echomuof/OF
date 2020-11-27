package 算法面试汇总;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2020/11/26
 */
public class LC只出现一次的数字 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans^=num;
        }
        return ans;
    }

}
