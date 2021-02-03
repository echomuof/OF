import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author: wangdarui
 * @created: 2021/2/3
 */
public class B1 {

    public static void main(String[] args) {
        String str = "DDDDoo yooouu lllovvvvvvvve     mmmmmmeee";
        str="aaabbb233ccc jjjkk112244lll iioooqquu  asd     sss ";
        System.out.println(func3(str));
        System.out.println();
    }

    public static String func(String str) {
        String[] sArr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sArr.length; i++) {
            if ("".equals(sArr[i])) continue;
            for (int j = 0; j < sArr[i].length(); j++) {
                if (j == sArr[i].length() - 1) {
                    sb.append(sArr[i].charAt(j));
                    continue;
                }
                if (sArr[i].charAt(j) == sArr[i].charAt(j + 1))
                    continue;
                sb.append(sArr[i].charAt(j));
            }
            if (i < sArr.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    public static String func3(String str) {
        String[] sArr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < sArr.length; i++) {
            if ("".equals(sArr[i])) continue;
            for (int j = 0; j < sArr[i].length(); j++) {
                set.add(sArr[i].charAt(j));
            }
            Iterator<Character> iterator = set.iterator();
            while (iterator.hasNext()) sb.append(iterator.next());
            set.removeAll(set);
            if (i < sArr.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    public static int[][] func2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int[][] remember = new int[matrix.length][matrix[0].length];
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] == 0) {
                    recur(matrix, remember, i, j);
                }
            }
        }
        return null;
    }

    public static boolean recur(int[][] matrix, int[][] remember, int x, int y) {
        if (remember[x][y] == 1) return true;
        if (matrix[x][y] == 1) {
            remember[x][y] = 1;
            return true;
        }
        return false;
    }
}
