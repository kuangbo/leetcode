package competition;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/9/27
 * Time: 上午10:35
 */
public class _5523 {
    public static void main(String[] args) {
        String[] logs = new String[]{"d1/","../","../","../"};
        System.out.println(minOperations(logs));
    }

    public static int minOperations(String[] logs) {
        int count = 0;
        for (String log : logs) {
            count += process(log);
            if (count < 0)
                count = 0;
        }
        return count;
    }

    public static int process(String str) {
        if ("./".equals(str))
            return 0;
        else if ("../".equals(str))
            return -1;
        else
            return 1;
    }
}
