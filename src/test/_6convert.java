package test;

class _6convert {
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder ret = new StringBuilder();
        int lens = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < lens; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < lens)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "AB";
        System.out.println(convert(s, 1));
    }
}
