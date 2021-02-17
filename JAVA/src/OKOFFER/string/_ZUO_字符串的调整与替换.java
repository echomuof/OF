package OKOFFER.string;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_字符串的调整与替换 {
    public static void replace(char[] chs) {
        if (chs == null || chs.length == 0) return;
        int len = 0;
        int num = 0;
        for (len = 0; len < chs.length && chs[len] != 0; len++) {
            if (chs[len] == ' ')
                num++;
        }
        int j = len + num * 2 - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (chs[i] != ' ') {
                chs[j--] = chs[i];
            } else {
                chs[j--] = '0';
                chs[j--] = '2';
                chs[j--] = '%';
            }
        }
    }

    public static void modify(char[] chs) {
        if (chs == null || chs.length == 0) return;
        int j = chs.length - 1;
        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] != '*') chs[j--] = chs[i];
        }
        while (j >= 0) {
            chs[j--] = '*';
        }
    }
}
