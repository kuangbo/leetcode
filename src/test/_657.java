package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/28
 * Time: 上午10:24
 */
public class _657 {
    public boolean judgeCircle(String moves) {
        int vFlag = 0;
        int hFlag = 0;
        char[] ch = moves.toCharArray();

        for (char c : ch) {
            switch (c) {
                case 'U':
                    vFlag++;
                    break;
                case 'D':
                    vFlag--;
                    break;
                case 'R':
                    hFlag++;
                    break;
                case 'L':
                    hFlag--;
                    break;
            }
        }
        return vFlag == 0 && hFlag == 0;
    }
}
