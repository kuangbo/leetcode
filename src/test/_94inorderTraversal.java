package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/18
 * Time: 下午3:33
 */
public class _94inorderTraversal {
    List<Integer> res = new ArrayList<>();  // 定义List集合，用于存放结果集

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);  // 中序遍历
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null)   // 当root为null时，不执行之后语句
            return;
        inorder(root.left); // 递归左子树
        res.add(root.val);  // 将该节点的值加入List集合
        inorder(root.right);    // 递归右子树
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
