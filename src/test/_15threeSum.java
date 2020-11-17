package test;

import java.util.*;

class _15threeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new _15threeSum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        if (len == 0)
            return new ArrayList<>(res);

        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                List<Integer> list = new ArrayList<>();
                int now = 0 - nums[i] - nums[j];
                System.out.println(nums[i] + " " + nums[j]);
                if (!map.containsKey(now)) {
                    map.put(nums[i], i);
                } else if(map.get(now) != i) {
                    list.add(now);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    res.add(list);
                }
            }
            while (i < len - 1 && nums[i] == nums[i + 1]) i++;
        }
        return new ArrayList<>(res);
    }
}
