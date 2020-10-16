package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/10/15
 */
public class _58_i_翻转单词顺序 {

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }

    public static String reverseWords(String s) {
        String[] sArr = s.trim().split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = sArr.length-1; i >= 0; i--) {
            if ("".equals(sArr[i])) continue;
            ans.append(sArr[i]);
            if (i>0) ans.append(" ");
        }
        return ans.toString();
    }
}
