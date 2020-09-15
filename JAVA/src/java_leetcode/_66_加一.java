package java_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/9/15
 */
public class _66_加一 {
    public static void main(String[] args) {
        int[] digits = {1, 9, 9, 9};
        plusOne(digits);
    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] >= 10) {
                digits[i] %= 10;
                digits[i - 1]++;
            }
        }
        if (digits[0] >= 10) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }


}
