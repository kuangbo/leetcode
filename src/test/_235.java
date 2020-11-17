package test;

public class _235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q) // 如果当前节点等于p或q，返回当前节点
            return root;
        // 递归左右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)  //如果左右子树的返回结果都不为null，返回当前节点
            return root;
        else if (left != null)
            return left;
        else return right;
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
