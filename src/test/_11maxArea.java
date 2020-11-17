package test;

class _11maxArea {
    private int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int area = 0;
        while (i < j) {
//            int min = Math.min(height[i], height[j]);
            int min = height[i] < height[j] ? height[i] : height[j];
//            area = Math.max(area, min * (j - i));
            area = area > min * (j - i) ? area : min * (j - i);
            if (height[i] <= height[j])
                i++;
            else if (height[i] > height[j])
                j--;
        }
        return area;
    }

    public static void main(String[] args) {
        int [] height = new int []{1,8,6,2,5,4,8,3,7};
        System.out.println(new _11maxArea().maxArea(height));
    }
}
