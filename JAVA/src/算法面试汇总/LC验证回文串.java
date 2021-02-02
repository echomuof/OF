package 算法面试汇总;

/**
 * @author: wangdarui
 * @created: 2020/11/27
 */
public class LC验证回文串 {

    public static void main(String[] args) {
        LC验证回文串 a = new LC验证回文串();
        String s = ",.";
        System.out.println(a.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            while (!((cl >= '0' && cl <= '9') || (cl >= 'A' && cl <= 'Z') || (cl >= 'a' && cl <= 'z')) && l < r) cl = s.charAt(++l);
            while (!((cr >= '0' && cr <= '9') || (cr >= 'A' && cr <= 'Z') || (cr >= 'a' && cr <= 'z')) && l < r) cr = s.charAt(--r);
            if (l == r) return true;
            if (cl < 'a') cl += 32;
            if (cr < 'a') cr += 32;
            if (cl != cr) return false;
            l++;
            r--;
        }
        return true;
    }
}
