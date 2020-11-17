package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/18
 * Time: 上午10:01
 */
public class _107levelOrderBottom {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        LinkedList<List<Integer>> res = new LinkedList<>(); // LinkedList有队头插入数据的功能
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);    // 存入根节点
        while (!queue.isEmpty()) {   // 循环直至queue队列为null
            int count = queue.size();   // 取出当前队列的大小
            List<Integer> temp = new ArrayList<>(); // 用于暂存当前行的数据
            while (count > 0) {
                TreeNode p = queue.poll();  // 取出数据
                temp.add(p.val);
                if (p.left != null)  // 左子树非null，加入queue
                    queue.add(p.left);
                if (p.right != null)  // 右子树非null，加入queue
                    queue.add(p.right);
                count--;
            }
            res.addFirst(temp); // 队头插入数据
        }
        return res;
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
