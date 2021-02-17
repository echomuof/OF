package OKOFFER.string;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_判断两个字符串是否互为变形词 {

    public static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) return false;
        char[] chArr1 = str1.toCharArray();
        char[] chArr2 = str2.toCharArray();
        int[] map = new int[256];
        for (char c : chArr1) {
            map[c]++;
        }
        for (char c : chArr2) {
            if (map[c]-- == 0) {
                return false;
            }
        }
        return true;
    }

}
