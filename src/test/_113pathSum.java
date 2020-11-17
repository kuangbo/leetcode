package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/18
 * Time: 下午4:33
 */
public class _113pathSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> temp = new ArrayList<>();
        process(root, sum, temp);
        return res;
    }
    public static List<List<Integer>> res = new ArrayList<>();
    public static void process(TreeNode root, int sum, List<Integer> temp) {
        if(root == null)
            return;
        temp.add(root.val);
        if(root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(temp));
        }
        process(root.left, sum - root.val, temp);
        process(root.right, sum - root.val, temp);
        temp.remove(temp.size() - 1);
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
