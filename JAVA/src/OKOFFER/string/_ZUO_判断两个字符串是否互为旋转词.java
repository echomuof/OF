package OKOFFER.string;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_判断两个字符串是否互为旋转词 {

    public static void main(String[] args) {
        String str1 = "12345";
        String str2 = "34512";
        System.out.println(isRotation(str1, str2 ));
    }

    public static boolean isRotation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;
        String s2 = str2 + str2;
        return s2.contains(str1);
    }

}
