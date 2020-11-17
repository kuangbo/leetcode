package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _697 {
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            map.put(nums[i], map.getOrDefault(nums[i], list));
            map.get(nums[i]).add(i);
        }
        int maxlen = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key).size() > maxlen) {
                maxlen = map.get(key).size();
            }
        }
        List<List<Integer>> maxList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key).size() == maxlen) {
                maxList.add(map.get(key));
            }
        }

        int min = Integer.MAX_VALUE;
        for (List<Integer> temp : maxList) {
            int begin = temp.get(0);
            int end = temp.get(temp.size() - 1);
            if (min > (end - begin))
                min = end - begin + 1;
        }

        return min;
    }
}
