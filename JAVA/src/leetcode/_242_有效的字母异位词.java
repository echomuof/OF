package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @date: 2020/9/19
 */
public class _242_有效的字母异位词 {
    public static void main(String[] args) {
        String s = s = "rat", t = "car";
        System.out.println(isAnagram2(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            map.put(chs[i], map.containsKey(chs[i]) ? map.get(chs[i]) + 1 : 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Integer value = map.get(t.charAt(i));
            if (value == null || value == 0) {
                return false;
            }
            map.put(t.charAt(i), value - 1);
        }
        return true;
    }
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] help = new int[26];
        for (int i = 0; i < s.length(); i++) {
            help[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            help[t.charAt(i) - 'a']--;
            if (help[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
