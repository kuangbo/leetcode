package offer_jianzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/15
 * Time: 下午7:52
 */
public class _offer_37 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);
        Codec codec = new Codec();
        TreeNode res = codec.deserialize(codec.serialize(A));
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null)
            return "null";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode == null) {
                sb.append("null").append(",");
            } else {
                sb.append(tempNode.val).append(",");
                queue.offer(tempNode.left);
                queue.offer(tempNode.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("null".equals(data))
            return null;
        String[] treeStr = data.split(",");
        int foot = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(treeStr[0]));
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (!"null".equals(treeStr[foot])) {
                tempNode.left = new TreeNode(Integer.parseInt(treeStr[foot]));
                queue.offer(tempNode.left);
            }
            foot++;
            if (!"null".equals(treeStr[foot])) {
                tempNode.right = new TreeNode(Integer.parseInt(treeStr[foot]));
                queue.offer(tempNode.right);
            }
            foot++;
        }
        return root;
    }
}
