package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/17
 * Time: 下午6:21
 */
public class _29 {
    public int[] spiralOrder(int[][] matrix) {
        int rowLen = matrix.length;
        if (rowLen == 0)
            return new int[0];
        int colLen = matrix[0].length;
        int[] res = new int[rowLen * colLen];
        int foot = 0;
        int left = 0, top = 0;
        int right = colLen - 1, bottom = rowLen - 1;
        while (true) {
            for (int i = left; i <= right; i++)
                res[foot++] = matrix[top][i];
            if (++top > bottom)
                break;
            for (int i = top; i <= bottom; i++)
                res[foot++] = matrix[i][right];
            if (--right < left)
                break;
            for (int i = right; i >= left; i--) {
                res[foot++] = matrix[bottom][i];
            }
            if (--bottom < top)
                break;
            for (int i = bottom; i >= top; i--)
                res[foot++] = matrix[i][left];
            if (++left > right)
                break;
        }
        return res;
    }
}
