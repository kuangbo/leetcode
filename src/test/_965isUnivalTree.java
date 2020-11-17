package test;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/21
 * Time: 下午12:05
 */
public class _965isUnivalTree {
    // 深度优先迭代解法
    public boolean isUnivalTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int unival = root.val;
        while(!stack.isEmpty()) {
            int size = stack.size();
            for(int i = 0; i < size; i++) {
                TreeNode now = stack.pop();
                if(now.val != unival)
                    return false;
                if(now.right != null)
                    stack.push(now.right);
                if(now.left != null)
                    stack.push(now.left);
            }
        }
        return true;
    }
    // 深度优先递归解法
    public boolean isUnivalTree1(TreeNode root) {
        return dfs(root, root.val);
    }

    public boolean dfs(TreeNode root, int unival) {
        if (root == null)
            return true;
        if (root.val != unival)
            return false;
        boolean left = dfs(root.left, unival);
        boolean right = dfs(root.right, unival);
        return left && right;
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
