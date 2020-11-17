package test;

import java.util.HashMap;
import java.util.Map;

public class _105 {
    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {  // 取出中序，放入map集合，便于后面取出对应索引
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public static TreeNode build(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd, Map<Integer, Integer> map) {
        if (preBegin > preEnd || inBegin > inEnd)   // 如果开始位置大于结束位置，返回null
            return null;
        TreeNode root = new TreeNode(preorder[preBegin]);   // 新建前序当前数据为根节点，向下遍历左右子树
        int temp = map.get(preorder[preBegin]); // 根据前序第一数找出中序中的对应位置
        int inRoot = temp - inBegin;    // inRoot为当前中序的根节点，中间节点
        // 递归遍历左右子树
        root.left = build(preorder, preBegin + 1, preBegin + inRoot, inorder, inBegin, inBegin + inRoot - 1, map);
        root.right = build(preorder, preBegin + inRoot + 1, preEnd, inorder, inBegin + inRoot + 1, inEnd, map);
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
