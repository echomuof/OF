package leetcode;

import java.util.*;

/**
 * @author: wangdarui
 * @date: 2020/9/19
 */
public class _49_字母异位词分组 {
    public static void main(String[] args) {
        String[] strs = {"bdddddddddd", "bbbbbbbbbbc"};
        groupAnagrams(strs).forEach(list -> {
            System.out.println(Arrays.toString(list.toArray()));
        });
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        int[] help = new int[26];
        for (String str : strs) {
            Arrays.fill(help, 0);
            for (int i = 0; i < str.length(); i++) {
                help[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : help) {
                sb.append(".");
                sb.append(i);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
