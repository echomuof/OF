package OKOFFER.string;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_在有序但含有空的数组中查找字符串 {
    public static int getIndex(String[] strs, String str) {
        if (strs == null || strs.length == 0 || str == null) return -1;
        int l = 0;
        int r = strs.length - 1;
        int mid = 0;
        int ans = -1;
        int i = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (strs[mid] != null && strs[mid].equals(str)) {
                ans = mid;
                r = mid - 1;
            } else if (strs[mid] != null) {
                if (strs[mid].compareTo(str) < 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                i = mid;
                while (strs[i] == null && i > l) {
                    i--;
                }
                if (i < l || strs[i].compareTo(str) < 0) {
                    l = mid + 1;
                } else {
                    ans = strs[i].equals(str) ? i : ans;
                    r = i - 1;
                }
            }
        }
        return ans;
    }
}
