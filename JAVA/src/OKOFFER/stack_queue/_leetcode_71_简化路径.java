package OKOFFER.stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/2
 */
public class _leetcode_71_简化路径 {
    public String simplifyPath(String path) {
        if (path.equals("") || path.equals("/")) return "/";
        Deque<String> deque = new LinkedList<>();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.equals(".") || dir.equals("")) continue;
            if (dir.equals("..")) {
                deque.pollLast();
                continue;
            }
            deque.addLast(dir);
        }
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()) {
            ans.append("/").append(deque.pollFirst());
        }
        String s = ans.toString();
        return s.equals("")?"/": s;
    }
}
