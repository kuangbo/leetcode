package competition;

import java.util.Arrays;

public class _5550 {
    public static void main(String[] args) {
        int[] code = new int[]{2,4,9,3};
        int k = 0;
        System.out.println(Arrays.toString(decrypt(code, k)));
    }

    public static int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (code.length == 0)
            return new int[]{};
        if (k == 0) {
            return res;
        } else if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int temp = 0;
                for (int j = 1; j <= k; j++) {
                    int t = i + j;
                    if (t >= code.length) {
                        temp += code[t - code.length];
                    } else {
                        temp += code[t];
                    }
                }
                res[i] = temp;
            }
        } else {
            k = -k;
            for (int i = 0; i < code.length; i++) {
                int temp = 0;
                for (int j = 1; j <= k; j++) {
                    int t = i - j;
                    if (t < 0) {
                        temp += code[t + code.length];
                    } else {
                        temp += code[t];
                    }
                }
                res[i] = temp;
            }
        }
        return res;
    }
}
