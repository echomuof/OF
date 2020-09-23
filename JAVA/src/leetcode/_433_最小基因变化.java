package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wangdarui
 * @date: 2020/9/23
 */
public class _433_最小基因变化 {
    public static void main(String[] args) {
        _433_最小基因变化 a = new _433_最小基因变化();
        a.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"});
    }

    public int minMutation(String start, String end, String[] bank) {
        Set<String> hasSet = new HashSet<>();
        dfs(hasSet, start, end, bank, 0);
        return Integer.MAX_VALUE == minCount ? -1 : minCount;
    }

    int minCount = Integer.MAX_VALUE;

    public void dfs(Set<String> hasSet, String cur, String target, String[] bank, int count) {
        if (cur.equals(target)) {
            minCount = Math.min(count, minCount);
            return;
        }
        for (String s : bank) {
            int diff = 0;
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != s.charAt(i) && ++diff > 1) {
                    break;
                }
            }
            if (diff == 1 && !hasSet.contains(s)) {
                hasSet.add(s);
                dfs(hasSet, s, target, bank, count + 1);
                hasSet.remove(s);
            }
        }
    }
}
