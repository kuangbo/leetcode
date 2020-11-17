package offer_jianzhi;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/20
 * Time: 下午12:29
 */
public class _offer_32 {
    public static void main(String[] args) {

    }
    // 使用广度优先解决问题
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        queue.add(root);
        int index = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i ++) {
                TreeNode now = queue.poll();
                list.add(now.val);
                if(now.left != null)
                    queue.add(now.left);
                if(now.right != null)
                    queue.add(now.right);
            }
            index ++;
            if(index % 2 == 0)
                Collections.reverse(list);
            res.add(list);
        }
        res.remove(res.size() - 1);
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
