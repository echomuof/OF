package 剑指offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: wangdarui
 * @created: 2020/10/12
 */
public class _38_字符串的排列 {
    public static void main(String[] args) {
        _38_字符串的排列 a = new _38_字符串的排列();
        String[] strs = a.permutation2("abc");
        for (String str : strs) {
            System.out.println(str);
        }
    }

    public String[] permutation(String s) {
        Set<String> ans = new HashSet<>();
        recur(s, ans, "", new ArrayList<>());
        return ans.toArray(new String[ans.size()]);
    }

    public void recur(String s, Set<String> ans, String cur, List<Integer> has) {
        if (cur.length() == s.length()) {
            ans.add(cur);
        }
        for (int i = 0; i < s.length(); i++) {
            if (has.contains(i)) {
                continue;
            }
            has.add(i);
            recur(s, ans, cur + s.charAt(i), has);
            has.remove(has.size() - 1);
        }
    }

    List<String> ans = new ArrayList<>();

    char[] chs;

    public String[] permutation2(String s) {
        chs = s.toCharArray();
        dfs(0);
        return ans.toArray(new String[ans.size()]);
    }

    public void dfs(int x) {
        if (x == chs.length - 1) {
            ans.add(String.valueOf(chs));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < chs.length; i++) {
            if (set.contains(chs[i])) continue;
            set.add(chs[i]);
            swap(x, i);
            dfs(x + 1);
            swap(x, i);
        }
    }

    void swap(int a, int b) {
        char tmp = chs[a];
        chs[a] = chs[b];
        chs[b] = tmp;
    }

}
