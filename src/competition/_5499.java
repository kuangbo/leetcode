package competition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/30
 * Time: 上午10:31
 */
public class _5499 {
    public static void main(String[] args) {
        containsPattern(new int[]{6,3,5,5,5,5,1,5,6,2,5,1,2,5,3,5,1,3,5,5,6,4,1,2}, 1, 5);
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        int left = 0;
        int right = 0;
        int len = arr.length;
        if (len == 0 || len < m * k)
            return false;

        List<Integer> sq = new ArrayList<>();
        int count = 0;

        while (right < len) {
            if (sq.size() == 0) {
                right = left;
                for (int i = 0; i < m; i++) {
                    sq.add(arr[right + i]);
                }
                count++;
                right += m;
            } else {
                boolean flag = true;
                if (right + m <= len) {
                    for (int i = 0; i < m; i++) {
                        if (arr[right + i] != sq.get(i)) {
                            sq = new ArrayList<>();
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        count++;
                        left = right + 1;
                        right += m;
                    } else {
                        left++;
                        count = 0;
                    }
                } else {
                    right = len;
                }
                if (count == k)
                    return true;
            }
        }
        return false;
    }
}
