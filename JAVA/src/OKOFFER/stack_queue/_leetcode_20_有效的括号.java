package OKOFFER.stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _leetcode_20_有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (cur!=map.get(pop)) return false;
            }
        }
        return stack.isEmpty();
    }

}

