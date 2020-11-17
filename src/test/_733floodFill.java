package test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/16
 * Time: 上午10:08
 */
public class _733floodFill {
    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int[][] image = new int[][]{{1, 1, 1, 1}, {1, 1, 1, 0}, {1, 1, 0, 1}, {1, 1, 0, 1}};
        int[][] newImage = floodFill(image, 1, 1, 2);
        System.out.println(Arrays.deepToString(newImage));
    }

    private static void dfs(int[][] image, int sr, int sc, int newColor, int pre) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == newColor || image[sr][sc] != pre) {
        } else {
            int temp = image[sr][sc];
            image[sr][sc] = newColor;
            dfs(image, sr - 1, sc, newColor, temp);
            dfs(image, sr + 1, sc, newColor, temp);
            dfs(image, sr, sc - 1, newColor, temp);
            dfs(image, sr, sc + 1, newColor, temp);
        }
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
}
