package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/15
 * Time: 下午4:40
 */
public class _offer_13 {
    public static void main(String[] args) {
        Solution_13 solution_13 = new Solution_13();
        System.out.println(solution_13.movingCount(100,100,6));
    }
}

class Solution_13 {
    private int res = 0;
    private boolean[][] flag; // 标志位，标志是否访问过

    public int movingCount(int m, int n, int k) {
        flag = new boolean[m][n];
        movingCountHelper(0, 0, m, n, k);
        return res;
    }

    public void movingCountHelper(int i, int j, int m, int n, int k) {
        // 越界或访问过或大于k，直接返回
        if (i < 0 || i >= m || j < 0 || j >= n || flag[i][j] || countBitInteger(i, j) > k) {
            return;
        }
        res++;
        flag[i][j] = true;
        // 递归上下左右
        movingCountHelper(i - 1, j, m, n, k);
        movingCountHelper(i + 1, j, m, n, k);
        movingCountHelper(i, j - 1, m, n, k);
        movingCountHelper(i, j + 1, m, n, k);
    }

    // 计算int每一位的和
    public int countBitInteger(int a, int b) {
        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        while (b > 0) {
            sum += b % 10;
            b /= 10;
        }
        return sum;
    }
}
