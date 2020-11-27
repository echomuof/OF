package 算法面试汇总;

/**
 * @author: wangdarui
 * @created: 2020/11/27
 */
public class LC鸡蛋掉落 {
    public int superEggDrop(int K, int N) {
        int l = 0;
        int r = N - 1;
        int ans = 0;
        while (l < r) {
            ans++;
            int mid = l + (r - l) / 2;
            if (mid == K - 1) {
                return ans;
            } else if (mid > K - 1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
