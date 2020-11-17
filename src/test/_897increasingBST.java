package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/20
 * Time: 上午10:26
 */
public class _897increasingBST {

    TreeNode newRoot = new TreeNode(0);
    TreeNode pre = newRoot;

    public static void main(String[] args) {

    }

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return newRoot.right;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left); // 递归左子树
        pre.right = new TreeNode(root.val); // 新建节点赋值给pre的右子树
        pre = pre.right; // 递归左子树
        dfs(root.right);
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
