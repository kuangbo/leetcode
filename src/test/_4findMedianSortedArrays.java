package test;

import java.util.Arrays;

class _4findMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        int index = 0;
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
        while(i < nums1.length){
            nums[index++] = nums1[i++];
        }
        while(j < nums2.length){
            nums[index++] = nums2[j++];
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        index--;
        if (index % 2 != 1)
            return nums[index / 2];
        else
            return (nums[index / 2] + nums[index / 2 + 1]) / 2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
