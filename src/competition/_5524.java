package competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/9/27
 * Time: 上午10:44
 */
public class _5524 {
    public static void main(String[] args) {
        System.out.println(minOperationsMaxProfit(new int[]{3,4,0,5,1}, 1, 92));
    }

    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        List<Integer> profits = maxProfit(customers, boardingCost, runningCost);
        return Collections.max(profits) <= 0 ? -1 : profits.indexOf(Collections.max(profits)) + 1;
    }

    public static List<Integer> maxProfit(int[] customers, int boardingCost, int runningCost) {
        int len = customers.length;
        int sum_now = 0;
        List<Integer> profits = new ArrayList<>();
        int profit = 0;
        for (int i = 0; i < len || sum_now > 0; i++) {
            if (i < len)
                sum_now += customers[i];
            if (sum_now >= 4) {
                profit += 4 * boardingCost - runningCost;
                profits.add(profit);
                sum_now -= 4;
            } else {
                profit += sum_now * boardingCost - runningCost;
                profits.add(profit);
                sum_now = 0;
            }
        }
        return profits;
    }
}
