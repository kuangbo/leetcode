package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/29
 * Time: 上午10:56
 */
public class _337rob {
Map<TreeNode, Integer> map = new HashMap<>();

public int rob(TreeNode root) {
    if (root == null)
        return 0;
    // 利用备忘录消除重叠子问题
    if (map.containsKey(root))
        return map.get(root);
    // 抢，然后去下下家
    int do_it = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
    // 不抢，然后去下家
    int not_do = rob(root.left) + rob(root.right);
    int res = Math.max(do_it, not_do);
    map.put(root, res);
    return res;
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
