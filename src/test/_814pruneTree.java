package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/20
 * Time: 下午3:06
 */
public class _814pruneTree {
    public static void main(String[] args) {

    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        // 使用后序遍历，递归左右子树
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // 当当前节点值为0，并且左右节点为空时，root置为null
        if (root.val == 0 && root.left == null && root.right == null)
            root = null;
        return root;    // 返回root
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
