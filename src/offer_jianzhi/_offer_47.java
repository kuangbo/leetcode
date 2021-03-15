package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/14
 * Time: 下午7:02
 */
public class _offer_47 {
    public static void main(String[] args) {
        Solution_47 solution_47 = new Solution_47();
        System.out.println(solution_47.maxValue(new int[][]{{1, 2, 5}, {3, 2, 1}}));
    }
}

class Solution_47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
