import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: wangdarui
 * @created: 2020/9/30
 */
public class zhua {

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length;
        int i = 0;
        while (i < right) {
            if (nums[i] == 0) {
                swap(nums, left++, i++);
            } else if (nums[i] == 2) {
                swap(nums, i, --right);
            }else {
                i++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.containsKey(num) ? map.get(num) + 1 : 1;
            map.put(num, count);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(k, (o1, o2) -> o1.getValue() - o2.getValue());
        priorityQueue.addAll(map.entrySet());
        for (int i = 0; i < ans.length; i++) {
            ans[i] = priorityQueue.poll().getKey();
        }
        return ans;
    }
}



























