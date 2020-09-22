package leetcode;

import com.sun.corba.se.spi.orbutil.fsm.FSMImpl;

import java.util.*;

/**
 * @author: wangdarui
 * @date: 2020/9/22
 */
public class _71_简化路径 {
    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        _71_简化路径 a = new _71_简化路径();
        System.out.println(a.simplifyPath(path));
    }

    public String simplifyPath(String path) {
        if (path == "" || path == "/") {
            return "/";
        }
        Deque<String> stack = new LinkedList<>();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.equals(".") || dir.equals("")) {
                continue;
            }
            if (dir.equals("..")) {
                stack.pollLast();
                continue;
            }
            stack.addLast(dir);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += "/" + stack.pollFirst();
        }
        return res == "" ? "/" : res;
    }
}
