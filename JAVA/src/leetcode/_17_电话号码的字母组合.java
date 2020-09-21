package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangdarui
 * @date: 2020/9/21
 */
public class _17_电话号码的字母组合 {
    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return ans;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        process(ans, 0, digits, phoneMap, "");
        return ans;
    }

    public void process(List<String> res, int index, String digits, Map<Character, String> map, String str) {
        if (index == digits.length()) {
            res.add(str);
            return;
        }
        String s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            process(res, index + 1, digits, map, str + s.charAt(i));
        }
    }
}
