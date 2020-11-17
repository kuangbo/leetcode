package test;

public class _79 {
    public boolean exist(char[][] board, String word) {
        if (board == null)
            return false;
        char[] ch = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, ch, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, char[] ch, int i, int j, int index) {
        if (index >= ch.length)
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != ch[index])
            return false;
        board[i][j] += 256;
        boolean result = (helper(board, ch, i - 1, j, index + 1) || helper(board, ch, i + 1, j, index + 1) || helper(board, ch, i, j - 1, index + 1) || helper(board, ch, i, j + 1, index + 1));
        board[i][j] -= 256;
        return result;
    }
}
