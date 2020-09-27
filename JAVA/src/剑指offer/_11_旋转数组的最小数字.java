package 剑指offer;

/**
 * @author: wangdarui
 * @created: 2020/9/27
 */
public class _11_旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid]>numbers[r]) l = mid + 1;
            else if (numbers[mid]<numbers[r]) r = mid;
            else r--;
        }

        return numbers[l];
    }
}
