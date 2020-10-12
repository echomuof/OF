package 剑指offer;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangdarui
 * @created: 2020/10/12
 */
public class _34_二叉树中和为某一值的路径 {
    public static void main(String[] args) {

    }

    List<List<Integer>> ans;

    List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        if (root == null) return ans;
        recur(root, sum);
        return ans;
    }

    public void recur(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        }
        recur(root.left, target);
        recur(root.right, target);
        path.remove(path.size() - 1);
    }
}
