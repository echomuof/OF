package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/9/29
 */
public class 最少钞票 {
    public static void main(String[] args) {
        System.out.println(getCount(2000));
    }

    public static int getCount(int money) {
        int[] bankNotes = {100, 50, 20, 10, 5, 1};
        int count = 0;
        for (int bankNote : bankNotes) {
            count += money / bankNote;
            money %= bankNote;
        }
        return count;
    }
}
