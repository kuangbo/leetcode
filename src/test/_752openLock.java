package test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/19
 * Time: 上午11:42
 */
public class _752openLock {
public static void main(String[] args) {
    int res = openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
    System.out.println(res);
}

public static String addOne(String s, int j) { // 将s[j]向上拨动一次
    char[] ch = s.toCharArray();
    if (ch[j] == '9')
        ch[j] = '0';
    else
        ch[j] += 1;
    return new String(ch);
}

public static int openLock(String[] deadends, String target) {
    Set<String> deads = new HashSet<>(Arrays.asList(deadends)); // 记录跳过的死亡密码
    Set<String> visited = new HashSet<>();  // 记录已经穷举过的密码，放止走回头路
    Queue<String> queue = new LinkedList<>();
    queue.add("0000");
    visited.add("0000");
    int step = 0;   // 从起点开始启动BFS
    while (!queue.isEmpty()) {
        int count = queue.size();
        // 将当前队列中的所有节点向周围扩散
        while (count > 0) {
            String now = queue.poll();

            // 判断是否到达终点
            if (deads.contains(now)) {
                count--;
                continue;
            }
            if (now.equals(target))
                return step;
            // 将当前节点的未遍历相邻节点加入队列
            for (int j = 0; j < 4; j++) {
                String add = addOne(now, j);
                if (!visited.contains(add)) {
                    queue.add(add);
                    visited.add(add);
                }
                String sub = subOne(now, j);
                if (!visited.contains(sub)) {
                    queue.add(sub);
                    visited.add(sub);
                }
            }
            count--;
        }
        step++; // 在这里增加步数
    }
    return -1;  // 如果穷举完都没找到目标密码,那就是找不到了
}

public static String subOne(String s, int j) { // 将s[j]向下拨动一次
    char[] ch = s.toCharArray();
    if (ch[j] == '0')
        ch[j] = '9';
    else
        ch[j] -= 1;
    return new String(ch);
}
}
