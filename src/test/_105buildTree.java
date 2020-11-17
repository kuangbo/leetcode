package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/17
 * Time: 下午6:43
 */
public class _105buildTree {
    public static void main(String[] args) {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();    // 用于存放中序遍历的序列
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    public static TreeNode build(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd, Map<Integer, Integer> map) {
        if (preBegin > preEnd || inBegin > inEnd)   // 当开始位置大于结束位置，返回null
            return null;
        TreeNode root = new TreeNode(preorder[preBegin]);   // 根据前序第一个位置，创建当前根节点
        int inRoot = map.get(root.val); // 根据前序的第一个位置的值，获取中序对应的位置，也就是当前根节点在中序的位置
        int numLeft = inRoot - inBegin; // 下次递归左子树的节点数量
        // 递归遍历左右子树
        root.left = build(preorder, preBegin + 1, preBegin + numLeft, inorder, preBegin, inRoot - 1, map);
        root.right = build(preorder, preBegin + numLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);
        return root;
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
