package test;

import java.util.*;

public class _102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag = 1;
        while(!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> temp = new ArrayList<>();
            while(count > 0) {
                TreeNode p = queue.poll();
                temp.add(p.val);
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
                count --;
            }
            if (flag % 2 == 0) {
                Collections.reverse(temp);
            }
            flag ++ ;
            result.add(temp);
        }
        return result;
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
