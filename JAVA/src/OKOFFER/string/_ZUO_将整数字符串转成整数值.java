package OKOFFER.string;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_将整数字符串转成整数值 {

    public static boolean isValid(char[] chs) {
        if (chs[0] == '-' && (chs[0] < '0' || chs[0] > '9')) {
            return false;
        }
        if (chs[0] == '-' && (chs.length == 1 || chs[1] == '0')) {
            return false;
        }
        if (chs[0] == '0' && chs.length > 1) {
            return false;
        }
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] < '0' || chs[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static int convert(String str) {
        if (str == null || str.equals("")) return 0;
        char[] chs = str.toCharArray();
        if (!isValid(chs)) return 0;
        boolean posi = chs[0] != '-';
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = posi ? 0 : 1; i < chs.length; i++) {
            cur = '0' - chs[i];
            if ((res < minq) || (res == minq && cur < minr)) {
                return 0;
            }
            res = res * 10 + cur;
        }
        if (posi && res == Integer.MIN_VALUE) return 0;
        return posi ? -res : res;
    }

}
