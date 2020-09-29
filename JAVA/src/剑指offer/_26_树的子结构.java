package 剑指offer;

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnyURIDV;
import utils.TreeNode;

/**
 * @author: wangdarui
 * @created: 2020/9/28
 */
public class _26_树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
