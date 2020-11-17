package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/17
 * Time: 下午4:08
 */
public class _27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
        mirrorTree(root.left);
        mirrorTree(root.right);
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
