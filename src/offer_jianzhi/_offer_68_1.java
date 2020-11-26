package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/26
 * Time: 下午3:34
 */
public class _offer_68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val < p.val && root.val < q.val)   // p,q都在右子树
            return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val)  // p,q都在左子树
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
