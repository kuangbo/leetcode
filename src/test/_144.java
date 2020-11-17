package test;

import java.util.*;

public class _144 {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode now = stack.pop();
            list.add(now.val);
            // 右子树先进栈，栈后进先出
            if(now.right != null)
                stack.push(now.right);
            if(now.left != null)
                stack.push(now.left);
        }
        return list;
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
