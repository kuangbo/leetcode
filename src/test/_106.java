package test;

import java.util.HashMap;
import java.util.Map;

public class _106 {
    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    public static TreeNode build(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd, Map<Integer, Integer> map) {
        if (inBegin > inEnd || postBegin > postEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);   // 后序最后一个节点为根节点
        int temp = map.get(postorder[postEnd]);   // 取出postorder后序最后一个节点对应中序的位置
        int inRoot = temp - inBegin;    // 中序对应当前根节点位置
        // 递归遍历左右子树
        root.left = build(inorder, inBegin, inBegin + inRoot - 1, postorder, postBegin, postBegin + inRoot - 1, map);
        root.right = build(inorder, inBegin + inRoot + 1, inEnd, postorder, postBegin + inRoot, postEnd - 1, map);
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
