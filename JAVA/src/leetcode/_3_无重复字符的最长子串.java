package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @date: 2020/9/23
 */
public class _3_无重复字符的最长子串 {
    public static void main(String[] args) {
        _3_无重复字符的最长子串 a = new _3_无重复字符的最长子串();
        System.out.println(a.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null||s.equals("")) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            Integer lastI = map.get(s.charAt(i));
            if (lastI != null && lastI >= start) {
                start = lastI + 1;
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
