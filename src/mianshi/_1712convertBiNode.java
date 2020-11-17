package mianshi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/21
 * Time: 下午5:58
 */
public class _1712convertBiNode {
    TreeNode after = new TreeNode(0);
    TreeNode pre = after;
    // 中序遍历
    public TreeNode convertBiNode(TreeNode root) {
        if(root == null)
            return null;

        convertBiNode(root.left);
        // 使用pre节点将中序遍历出的节点串起来
        pre.right = new TreeNode(root.val);
        pre = pre.right;
        convertBiNode(root.right);
        return after.right;
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
