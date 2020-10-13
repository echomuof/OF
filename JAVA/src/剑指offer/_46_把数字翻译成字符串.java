package 剑指offer;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/10/13
 */
public class _46_把数字翻译成字符串 {

    public static void main(String[] args) {
        _46_把数字翻译成字符串 a = new _46_把数字翻译成字符串();
        System.out.println(a.translateNum(506));
    }

    public int translateNum(int num) {
        String[] ss = String.valueOf(num).split("");
        recur(ss, 0, new ArrayList<>());

        return list.size();
    }

    List<List<Integer>> list = new ArrayList<>();

    public void recur(String[] ss, int index, List<Integer> line) {
        if (index >= ss.length) {
            if (index == ss.length) list.add(new ArrayList<>(line));
            return;
        }
        int cur = 0;
        if (index <= ss.length - 2 && !ss[index].equals("0")) {

            cur = Integer.parseInt(ss[index] + ss[index + 1]);
            if (cur <= 25) {
                line.add(cur);
                recur(ss, index + 2, line);
                line.remove(line.size() - 1);
            }
        }
        line.add(Integer.parseInt(ss[index]));
        recur(ss, index + 1, line);
        line.remove(line.size() - 1);
    }
}
