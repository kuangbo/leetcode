package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/17
 * Time: 下午5:10
 */
public class _124maxPathSum {
    public static int res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        maxPathSum(root);
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        fun(root);
        return res;
    }

    public static int fun(TreeNode root) {
        if (root == null)   // 如果当前节点为null，返回0
            return 0;
        int left = Math.max(0, fun(root.left)); // 如果子树路径和为负则应当置0，表示最大路径不包含子树
        int right = Math.max(0, fun(root.right));
        res = Math.max(res, left + right + root.val);   // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(left, right) + root.val;    // 选择路径之和最大的子树加上自身的值
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
