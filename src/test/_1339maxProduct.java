package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/21
 * Time: 下午6:19
 */
public class _1339maxProduct {
    int nowSum = 0;

    public int maxProduct(TreeNode root) {
        int sum = count(root);
        process(root, sum / 2);
        System.out.println(sum / 2);
        System.out.println(nowSum);
        return (sum - nowSum) * sum;
    }

    public int process(TreeNode root, int mid) {
        if (root == null)
            return 0;
        int left = process(root.left, mid);
        int right = process(root.right, mid);
        System.out.println(left + right + root.val);
        if(left + right + root.val < mid)
            return left + right;
        nowSum = left + right + root.val;
        System.out.println(nowSum);
        return nowSum;
    }

    public int count(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + count(root.left) + count(root.right);
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
