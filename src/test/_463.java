package test;

import java.util.HashMap;
import java.util.Map;

public class _463 {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
        }
        int perimeter = 0;
        for (int i = 0; i <= map.size() - 1; i++) {
            if (i == 0) {
                perimeter = getSum(map.get(0)) - (map.size() > 1 ? Math.min(map.get(0), map.get(1)) : 0);
            } else if (i == map.size() - 1) {
                perimeter += getSum(map.get(map.size() - 1)) - Math.min(map.get(map.size() - 1), map.get(map.size() - 2));
            } else {
                perimeter += getSum(map.get(i)) - Math.min(map.get(i), map.get(i - 1)) - Math.min(map.get(i), map.get(i + 1));
            }
        }
        return perimeter;
    }

    public int getSum(int p) {
        return 2 * p + 2;
    }
}
