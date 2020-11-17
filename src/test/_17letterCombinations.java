package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17letterCombinations {
    private Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private List<String> output = new ArrayList<String>();

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new _17letterCombinations().letterCombinations(digits));
    }

    private void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0)
            output.add(combination);
        else {
            String digit = next_digits.substring(0, 1);
            String letters = map.get(digit);
            int lenle = letters.length();
            for (int i = 0; i < lenle; i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }

        }
    }

    private List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }
}
