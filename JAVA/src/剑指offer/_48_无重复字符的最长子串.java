package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @date: 2020/9/19
 */
public class _48_无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(maxLengthSonStr("abcabcabc"));
    }

    public static int maxLengthSonStr(String str) {
        if (str == null) {
            return 0;
        }
        if (str.length() == 0 || str.length() == 1) {
            return str.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            Integer last = map.get(str.charAt(i));
            if (last != null && last >= start) {
                start = last + 1;
            }
            count = Math.max(count, i - start + 1);
            System.out.println(i - start + 1);
            map.put(str.charAt(i), i);
        }
        return count;
    }

}
