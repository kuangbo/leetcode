package gongzizhenti;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/4/9
 * Time: 下午7:09
 */
public class ali01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t > 0) {
            --t;
            int n = scan.nextInt();
            int[] l = new int[n];
            int[] r = new int[n];
            for (int i = 0;i < n;i++) {
                l[i] = scan.nextInt();
                r[i] = scan.nextInt();
            }
            int time = 0;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                time += 1;
                if (time <= r[i]) {
                    time = Math.max(time, l[i]);
                    res[i] = time;
                } else {
                    res[i] = 0;
                    time -= 1;
                }
            }
            System.out.println(Arrays.toString(res));
        }

    }
}
