package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/15
 * Time: 下午6:46
 */
public class _offer_26 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        TreeNode B = new TreeNode(4);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);
        B.left = new TreeNode(1);
        Solution_26 solution_26 = new Solution_26();
        solution_26.isSubStructure(A, B);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 判特殊情况
        if (A == null || B == null)
            return false;
        // 判是否是子结构
        if (dfsFindSame(A, B))
            return true;
        // 递归左右子树
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean dfsFindSame(TreeNode A, TreeNode B) {
        // B为null，直接返回true
        if (B == null)
            return true;
        if (A == null)
            return false;
        // 递归左右是否相等
        return A.val == B.val && dfsFindSame(A.left, B.left) && dfsFindSame(A.right, B.right);
    }
}
