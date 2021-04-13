package moreandmore.wordcount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/4/12
 * Time: 下午2:56
 */
public class WordCount01 {
    private int threadNum;
    private ExecutorService executorService;

    public WordCount01(int threadNum) {
        executorService = Executors.newFixedThreadPool(threadNum);
        this.threadNum = threadNum;
    }

    public static void main(String[] args) throws FileNotFoundException, ExecutionException, InterruptedException {
        File file = new File("/media/kuangbo/newfolder/bigdata/demo/input/wordcount2.txt");

        WordCount01 wordCount01 = new WordCount01(10);
        Map<String, Integer> res = wordCount01.map(file);
        for (Map.Entry<String, Integer> item : res.entrySet()) {
            System.out.println(item.getKey() + "\t" + item.getValue());
        }
        // res.forEach((a, b) -> System.out.println(a + "\t" + b));
    }

    public Map<String, Integer> map(File file) throws FileNotFoundException, ExecutionException, InterruptedException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        // List<Future<Map<String, Integer>>> threadMapList = new ArrayList<>();
        List<FutureTask<Map<String, Integer>>> futureTaskList = new ArrayList<>();

        for (int i = 0; i < threadNum; i++) {
            FutureTask<Map<String, Integer>> futureTask = new FutureTask<>(() -> {
                Map<String, Integer> threadMap = new HashMap<>();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] str = line.split(" ");
                    for (String s : str) {
                        threadMap.put(s, threadMap.getOrDefault(s, 0) + 1);
                    }
                }
                return threadMap;
            });
            executorService.submit(futureTask);
            futureTaskList.add(futureTask);
        }
        Map<String, Integer> resMap = new HashMap<>();
        for (FutureTask<Map<String, Integer>> mapFuture : futureTaskList) {
            Map<String, Integer> map = mapFuture.get();
            System.out.println(map.toString());
            reduce(map, resMap);
        }
        return resMap;
    }

    public void reduce(Map<String, Integer> map, Map<String, Integer> resMap) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            resMap.put(entry.getKey(), resMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }
}
