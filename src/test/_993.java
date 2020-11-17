package test;

import java.util.*;

public class _993 {

    public static void main(String[] args) {
        Map<TreeNode, TreeNode> map = new HashMap();
        map.put(new TreeNode(0), new TreeNode(1));
        System.out.println(map.get(new TreeNode(0)));
    }

    static int prex = 0;
    static int prey = 0;
    static int posx = 0;
    static int posy = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0);
        return posx == posy && prex != prey;
    }

    public void dfs(TreeNode root, int x, int y, int depth) {
        if (root != null) {
            if (root.left != null && root.left.val == x) {
                posx = depth;
                prex = root.val;
            }
            if(root.right != null && root.right.val == x) {
                posx = depth;
                prex = root.val;
            }
            if (root.left != null && root.left.val == y) {
                posy = depth;
                prey = root.val;
            }
            if(root.right != null && root.right.val == y) {
                posy = depth;
                prey = root.val;
            }
            dfs(root.left, x, y, depth + 1);
            dfs(root.right, x, y, depth + 1);
        }
    }

    public boolean isCousins1(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode now = queue.poll();
                list.add(now == null ? null : now.val);
                if (now == null)
                    continue;
                queue.add(now.left);
                queue.add(now.right);
            }
            if (list.contains(x) && list.contains(y) && !(Math.abs(list.indexOf(x) - list.indexOf(y)) == 1 && Math.max(list.indexOf(x), list.indexOf(y)) % 2 == 1))
                return true;
        }
        return false;
    }

    public static class TreeNode {
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
