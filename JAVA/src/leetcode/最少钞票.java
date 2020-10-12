package leetcode;

import java.util.Arrays;

/**
 * @author: wangdarui
 * @created: 2020/9/29
 */
public class 最少钞票 {
    public static void main(String[] args) {
        int[] bankNotes = {1, 2, 5};
        System.out.println(getCount(bankNotes, 0));
    }

    public static int getCount(int[] cars, int num) {
        Arrays.sort(cars);
        int ans = 0;
        for (int i = cars.length - 1; i >= 0; i--) {
            ans += num / cars[i];
            num %= cars[i];
        }
        return ans == 0 ? -1 : ans;
    }
}
