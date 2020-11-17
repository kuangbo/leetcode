package test;

public class _606 {
    StringBuilder str = new StringBuilder();    // 创建StringBuilder对象，存放之后的字符

    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        dfs(t);
        String res = str.toString();
        return res.substring(1, str.length() - 1);  // 截取掉第一个'('和最后一个')'
    }

    public void dfs(TreeNode t) {
        if (t == null) return;  // 若当前节点为null，直接返回
        str.append('(');    // 加入'('
        str.append(t.val);  // 加入当前值
        if (t.left != null) // 当左节点不为null，递归左子树
            dfs(t.left);
        else
            str.append("()");   // 根据题意，不能省略第一对'()'，所以若左节点为null，需要添加'()'
        if (t.right != null)    // 若右节点不为null，递归右子树
            dfs(t.right);
        // 在结束之前，判断空'()'括号并删除
        // 若当前str中最后两个字符为'()'，直接删去
        int nowLen = str.length();  // 获取str当前长度
        if (str.lastIndexOf(")") == nowLen - 1 && str.lastIndexOf("(") == nowLen - 2) {
            str.delete(nowLen - 2, nowLen);
        }
        str.append(')');    // 加入'('
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
