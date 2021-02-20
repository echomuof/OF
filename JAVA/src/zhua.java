/**
 * @author: wangdarui
 * @created: 2020/9/30
 */
public class zhua {

    static int i;

    public zhua add() {
        i++;
        return this;
    }

    private void show() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double mid = (double) (nums1.length + nums2.length - 1) / 2;
        int left = (int) Math.floor(mid);
        int right = (int) Math.ceil(mid);
        int[] help = new int[nums1.length + nums2.length];
        int l1 = 0;
        int l2 = 0;
        int a = 0, b = 0;
        int i = 0;
        while (l1 < nums1.length || l2 < nums2.length) {
            if (l1>=nums1.length) help[i] = nums2[l2++];
            else if (l2>=nums2.length) help[i] = nums1[l1++];
            else help[i] = nums1[l1] <= nums2[l2] ? nums1[l1++] : nums2[l2++];

            if (i == left) a = help[i];
            if (i == right) {
                b = help[i];
                break;
            }
            i++;
        }
        return (double) (a + b) / 2;
    }
}



























