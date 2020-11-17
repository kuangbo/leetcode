package test;

public class _1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 0 || arr.length == 1)
            return true;
        int max = arr[0];
        int min = arr[0];
        for (int a : arr) {
            if (a < min)
                min = a;
            if (a > max)
                max = a;
        }
        int sub = (max - min) / (arr.length - 1);
        int remainder = (max - min) % (arr.length - 1);
        int sum = sub + remainder;
        if (sum == 0)
            return true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == 0)
                return false;
            if ((arr[i] - arr[i - 1]) % sum != 0) {
                return false;
            }
        }
        return true;
    }
}
