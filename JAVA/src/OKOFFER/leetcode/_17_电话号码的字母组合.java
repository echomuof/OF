package OKOFFER.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _17_电话号码的字母组合 {

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
        process(ans,0,digits,phoneMap,"");
        return ans;
    }

    public void process(List<String> ans, int index, String digits, Map<Character, String> phoneMap, String str) {
        if (index == digits.length()) {
            ans.add(str);
            return;
        }
        String cur = phoneMap.get(digits.charAt(index));
        for (int i = 0; i < cur.length(); i++) {
            process(ans, index + 1, digits, phoneMap, str + cur.charAt(i));
        }
    }


}
