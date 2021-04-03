package offer_jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/18
 * Time: 上午9:52
 */
public class _offer_34 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(-2);
        A.right = new TreeNode(-3);
        System.out.println(new Solution_34().pathSum(A, -5));
    }
}

class Solution_34 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> tmpList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null)
            return;
        tmpList.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            res.add(new ArrayList<>(tmpList));
            tmpList.remove(tmpList.size() - 1);
            return;
        }
        target -= root.val;
        dfs(root.left, target);
        dfs(root.right, target);
        tmpList.remove(tmpList.size() - 1);
    }
}
