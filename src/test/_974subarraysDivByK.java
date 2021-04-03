package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/29
 * Time: 下午7:25
 */
public class _974subarraysDivByK {
    public static void main(String[] args) {
        System.out.println(new Solution_974().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1, 5}, 5));
    }
}

class Solution_974 {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            arr[i] = arr[i - 1] + A[i - 1];
            arr[i] = (arr[i] % K + K) % K;
        }
        int res = 0;
        System.out.println(Arrays.toString(arr));
        for (int a : arr) {
            if (map.containsKey(a)) {
                res += map.get(a);
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return res;
    }
}
