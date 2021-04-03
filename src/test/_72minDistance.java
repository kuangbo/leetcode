package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/4/1
 * Time: 下午5:02
 */
public class _72minDistance {
    public static void main(String[] args) {
        System.out.println(new Solution_72().minDistance("horse", "ros"));
    }
}

class Solution_72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0)
            return n + m;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
