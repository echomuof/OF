package OKOFFER.string;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_字符串的统计字符串 {

    public static void main(String[] args) {
        System.out.println(getCountString("aaabbadddffc"));
    }

    public static String getCountString(String str) {
        if (str == null || str.equals("")) return "";
        char[] chs = str.toCharArray();
        String ans = String.valueOf(chs[0]);
        int num = 1;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] != chs[i - 1]) {
                ans = concat(ans, String.valueOf(num), String.valueOf(chs[i]));
                num = 1;
            } else {
                num++;
            }
        }
        return concat(ans, String.valueOf(num), "");
    }

    public static String concat(String s1, String s2, String s3) {
        return s1 + "_" + s2 + (s3.equals("") ? s3 : "_" + s3);
    }
}
