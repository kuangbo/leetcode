package test;

class _12intToRoman {
    public static void main(String[] args) {
        int num = 14;
        System.out.println(new _12intToRoman().intToRoman(num));
    }

    private String intToRoman(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        System.out.println(romans.length + "--" + nums.length);
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (num > 0) {
            while (num >= nums[index]) {
                res.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return res.toString();
    }
}
