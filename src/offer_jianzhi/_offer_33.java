package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/14
 * Time: 下午1:02
 */
public class _offer_33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return true;
        return verifyPostorderHelper(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorderHelper(int[] postorder, int i, int j) {
        if (i >= j)
            return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && verifyPostorderHelper(postorder, i, m - 1) && verifyPostorderHelper(postorder, m, j - 1);
    }
}
