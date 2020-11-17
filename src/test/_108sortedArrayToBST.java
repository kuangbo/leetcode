package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/20
 * Time: 下午12:08
 */
public class _108sortedArrayToBST {
    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sort(nums, 0, nums.length);
    }
    public static TreeNode sort(int[] nums, int start, int end) {
        if(start >= end)    // 使用左闭右开区间，当start >= end的时候，返回null
            return null;
        int mid = start + (end - start) / 2;    // 类似二分查找，取中间位置
        TreeNode root = new TreeNode(nums[mid]); // 实例化当前节点
        // 递归创建左右子树
        root.left = sort(nums, start, mid);
        root.right = sort(nums, mid + 1, end);
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
