package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/21
 * Time: 上午11:58
 */
public class _54 {
    int res = 0;
    int count = 0;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if (root != null) {
            dfs(root.right, k);
            count++;
            if (count == k) {
                res = root.val;
                return;
            }
            dfs(root.left, k);
        }
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
