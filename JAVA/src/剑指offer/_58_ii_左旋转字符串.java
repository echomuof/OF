package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/10/15
 */
public class _58_ii_左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) sb.append(s.charAt(i));
        for (int i = 0; i < n; i++) sb.append(s.charAt(i));
        return sb.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

}
