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
public class WordCount04 {
    public ExecutorService executorService;
    private int threadNum;
    private long beginTime;

    public WordCount04(int threadNum) {
        executorService = Executors.newFixedThreadPool(threadNum);
        this.threadNum = threadNum;
        beginTime = System.currentTimeMillis();
    }

    public static void main(String[] args) throws FileNotFoundException, ExecutionException, InterruptedException {
        File file1 = new File("/media/kuangbo/newfolder/bigdata/demo/input/wordcount1.txt");
        File file2 = new File("/media/kuangbo/newfolder/bigdata/demo/input/wordcount2.txt");
        File file3 = new File("/media/kuangbo/newfolder/bigdata/demo/input/wordcount3.txt");
        File file4 = new File("/media/kuangbo/newfolder/bigdata/demo/input/wordcount4.txt");
        File file5 = new File("/media/kuangbo/newfolder/bigdata/demo/input/wordcount5.txt");
        File file6 = new File("/media/kuangbo/newfolder/bigdata/demo/input/wordcount6.txt");
        List<File> fileList = new ArrayList<>();
        fileList.add(file1);
        fileList.add(file2);
        fileList.add(file3);
        fileList.add(file4);
        fileList.add(file5);
        fileList.add(file6);

        WordCount04 wordCount01 = new WordCount04(10);
        Map<String, Integer> resMap = new HashMap<>();
        wordCount01.map(fileList, resMap);
        for (Map.Entry<String, Integer> item : resMap.entrySet()) {
            System.out.println(item.getKey() + "\t" + item.getValue());
        }
        wordCount01.executorService.shutdown();
        // res.forEach((a, b) -> System.out.println(a + "\t" + b));
    }

    public FutureTask<Map<String, Integer>> createFutureTask(File file) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
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
        return futureTask;
    }

    public void map(List<File> fileList, Map<String, Integer> resMap) throws FileNotFoundException, ExecutionException, InterruptedException {
        List<FutureTask<Map<String, Integer>>> futureTaskList = new ArrayList<>();
        for (File file : fileList) {
            FutureTask<Map<String, Integer>> futureTask = createFutureTask(file);
            executorService.submit(futureTask);
            futureTaskList.add(futureTask);
        }
        for (FutureTask<Map<String, Integer>> mapFuture : futureTaskList) {
            Map<String, Integer> map = mapFuture.get();
            System.out.println(map.toString());
            System.out.println(System.currentTimeMillis() - beginTime + " ms");
            reduce(map, resMap);
        }
    }

    public void reduce(Map<String, Integer> map, Map<String, Integer> resMap) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            resMap.put(entry.getKey(), resMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }
}
