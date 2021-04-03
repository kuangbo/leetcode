package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/15
 * Time: 下午3:42
 */
public class _offer_12 {
    public static void main(String[] args) {
        char[][] ch = new char[][]{{'a','b','f','e'},{'s','f','c','s'},{'a','d','e','e'}};
        String word = "bcced";
        Solution_12 solution_12 = new Solution_12();
        solution_12.exist(ch, word);
    }
}

class Solution_12 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] ch = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 双重循环遍历
                if (dfs(board, ch, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] ch, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != ch[k])
            return false;
        if (k == ch.length - 1)
            return true;
        // 对(i,j)置'\0'，表示访问过
        board[i][j] = '\0';
        // 递归上下左右
        boolean flag = dfs(board, ch, i - 1, j, k + 1) || dfs(board, ch, i + 1, j, k + 1) || dfs(board, ch, i, j - 1, k + 1) || dfs(board, ch, i, j + 1, k + 1);
        // 放回原来的元素
        board[i][j] = ch[k];
        return flag;
    }
}
