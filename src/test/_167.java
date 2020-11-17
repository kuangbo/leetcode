package test;

public class _167 {
    // 使用类似双指针的策略 + 二分查找
    public int[] twoSum(int[] numbers, int target) {
        int pos1 = 0;   // 指向数组的第一个元素
        int pos2 = numbers.length - 1;  // 指向数组的最后一个元素

        while (pos1 <= pos2) {
            int num1 = numbers[pos1];
            int num2 = numbers[pos2];
            if (num1 + num2 == target)
                return new int[]{pos1 + 1, pos2 + 1};
            else if (num1 + num2 > target)
                pos2--;
            else if (num1 + num2 < target)
                pos1++;
        }
        return new int[]{};
    }
}
