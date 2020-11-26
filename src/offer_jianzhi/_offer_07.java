package offer_jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/26
 * Time: 上午10:42
 */
public class _offer_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    public TreeNode helper(int[] preorder, int preBegin, int preEnd, int inBegin, int inEnd, Map<Integer, Integer> map) {
        if (preBegin > preEnd || inBegin > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preBegin]);
        int inRoot = map.get(root.val);
        int numLeft = inRoot - inBegin;
        root.left = helper(preorder, preBegin + 1, preBegin + numLeft, inBegin, inBegin + numLeft - 1, map);
        root.right = helper(preorder, preBegin + numLeft + 1, preEnd, inBegin + numLeft + 1, inEnd, map);
        return root;
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
