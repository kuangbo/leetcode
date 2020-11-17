package offer_jianzhi;

import java.util.ArrayList;
import java.util.List;

public class _offer_54 {
    public static void main(String[] args) {

    }

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return list.get(list.size() - 1);
    }

    List<Integer> list = new ArrayList<>();
    public void dfs(TreeNode root, int k) {
        if(root != null) {
            dfs(root.left, k);
            list.add(root.val);
            dfs(root.right, k);
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
