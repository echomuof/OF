package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/9/17
 */
public class _5_替换空格 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chs[i]);
            }
        }
        return sb.toString();
    }
}
