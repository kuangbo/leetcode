package test;

import java.util.ArrayList;
import java.util.List;

public class _22 {
    public static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }
    public static void dfs(int left, int right, String curStr) {
        if(left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
        if(left > 0) {
            dfs(left - 1, right, curStr + "(");
        }
        if(right > left){
            dfs(left, right - 1, curStr + ")");
        }
    }
}
