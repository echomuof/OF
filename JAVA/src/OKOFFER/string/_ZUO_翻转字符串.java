package OKOFFER.string;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_翻转字符串 {

    public static void main(String[] args) {
        String str = "I’m a student.";
        char[] chs = str.toCharArray();
        reverseWord(chs);
        System.out.println(String.valueOf(chs));
        String str2 = "ABCDE";
        char[] chs2 = str2.toCharArray();
        reverseWord2(chs2, 3);
        System.out.println(String.valueOf(chs2));
    }

    public static void reverseWord(char[] chs) {
        if (chs == null || chs.length == 0) return;
        reverse(chs, 0, chs.length - 1);
        int l = -1;
        int r = -1;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] != ' ') {
                l = i == 0 || chs[i - 1] == ' ' ? i : l;
                r = i == chs.length - 1 || chs[i + 1] == ' ' ? i : r;
            }
            if (l != -1 && r != -1) {
                reverse(chs, l, r);
                l = -1;
                r = -1;
            }
        }
    }

    public static void reverseWord2(char[] chs, int size) {
        if (chs == null || chs.length == 0) return;
        reverse(chs, 0, size - 1);
        reverse(chs, size, chs.length - 1);
        reverse(chs, 0, chs.length - 1);
    }

    public static void reverse(char[] chs, int start, int end) {
        while (start < end) {
            char tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            start++;
            end--;
        }
    }

}
