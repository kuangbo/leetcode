package mianshi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/21
 * Time: 下午12:14
 */
public class _0402sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums, 0, nums.length);
    }

    public TreeNode process(int[] nums, int start, int end) {
        if (start >= end) // 此时表示nums数组中无元素，直接返回
            return null;
        int mid = start + (end - start) / 2;    // 计算出当前中间节点，作为根节点
        TreeNode root = new TreeNode(nums[mid]);    // 创建节点
        // 递归创建左右子树
        root.left = process(nums, start, mid);
        root.right = process(nums, mid + 1, end);
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
