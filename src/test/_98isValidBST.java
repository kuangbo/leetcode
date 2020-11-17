package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/18
 * Time: 下午1:27
 */
public class _98isValidBST {

    TreeNode pre;

    public static void main(String[] args) {

    }

    /**
     * 思想与恢复二叉搜索树相同，都是通过中序遍历进行的
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        boolean leftFlag = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) {    // 当设置的前驱节点不为空并且前驱节点的值>=当前根节点的值，返回false
            return false;
        }
        pre = root; // 将当前根节点赋值到pre，作为下一次迭代的前驱节点
        boolean rightFlag = isValidBST(root.right);
        return leftFlag && rightFlag;   // 返回左右子树的flag
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
