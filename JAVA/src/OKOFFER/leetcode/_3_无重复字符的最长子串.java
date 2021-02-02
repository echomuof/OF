package OKOFFER.leetcode;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2021/2/1
 */
public class _3_无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s==null||s.equals("")) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer lastI = map.get(s.charAt(i));
            if (lastI != null && lastI >= start)
                start = lastI + 1;
            ans = Math.max(ans, i - start + 1);
            map.put(s.charAt(i), i);
        }
        return ans;
    }
}