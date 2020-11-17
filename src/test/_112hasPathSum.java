package test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/18
 * Time: 下午4:33
 */
public class _112hasPathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if(root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        queue.add(root);
        queueVal.add(root.val);
        while(!queue.isEmpty()) {
            TreeNode now = queue.poll();
            int temp = queueVal.poll();
            if(now.left == null && now.right == null) {
                if(temp == sum)
                    return true;
            }
            if(now.left != null) {
                queue.add(now.left);
                queueVal.add(now.left.val + temp);
            }
            if(now.right != null) {
                queue.add(now.right);
                queueVal.add(now.right.val + temp);
            }
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)    // 当前根节点为null，返回false
            return false;
        if (root.left == null && root.right == null) // 当前节点左右节点都为null，判断sum - root.val是否为0
            return sum - root.val == 0;
        // 递归左右子树
        // 在递归过程中，sum - 当前节点root.val传入下面递归
        boolean leftFlag = hasPathSum(root.left, sum - root.val);
        boolean rightFlag = hasPathSum(root.right, sum - root.val);
        return leftFlag || rightFlag;
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
