package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/18
 * Time: 上午10:36
 */
public class _99recoverTree {
    TreeNode pre, t1, t2;   // t1,t2记录两个错误节点

    public static void main(String[] args) {

    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (pre != null && root.val < pre.val) {
            t1 = (t1 == null) ? pre : t1;   // 找到错误节点放入t1
            t2 = root;  // 如果当前节点值小于前驱节点值，更新t2为当前节点值
        }
        pre = root; // 当前节点作为下面的前驱节点
        inorder(root.right);
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
