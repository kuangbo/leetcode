// package moreandmore.wordcount;
//
// import org.apache.hadoop.conf.Configuration;
// import org.apache.hadoop.fs.Path;
// import org.apache.hadoop.io.IntWritable;
// import org.apache.hadoop.io.LongWritable;
// import org.apache.hadoop.io.Text;
// import org.apache.hadoop.mapreduce.Job;
// import org.apache.hadoop.mapreduce.Mapper;
// import org.apache.hadoop.mapreduce.Reducer;
// import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
// import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
//
// import java.io.IOException;
//
// /**
//  * Created with IntelliJ IDEA.
//  * User: kuangbo
//  * Date: 2021/4/9
//  * Time: 下午8:08
//  */
// public class WordCount01 {
//     public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
//         // 1、获取配置信息以及获取job对象
//         Configuration conf = new Configuration();
//         Job job = Job.getInstance(conf);
//
//         // 2、关联Driver程序的jar
//         job.setJarByClass(WordCount01.class);
//
//         // 3、关联Mapper和Reducer的jar
//         job.setMapperClass(WordCountMapper.class);
//         job.setReducerClass(WordCountReducer.class);
//
//         // 4、设置Mapper输出的kv类型
//         job.setMapOutputKeyClass(Text.class);
//         job.setMapOutputValueClass(IntWritable.class);
//
//         // 5、设置最终输出的kv类型
//         job.setOutputKeyClass(Text.class);
//         job.setOutputValueClass(IntWritable.class);
//
//         // 6、设置输入和输出路径
//         FileInputFormat.setInputPaths(job, new Path("/media/kuangbo/newfolder/bigdata/demo/input/wordcount.txt"));
//         FileOutputFormat.setOutputPath(job, new Path("/media/kuangbo/newfolder/bigdata/demo/input/wordcountResult"));
//
//         // 7、提交job
//         System.exit(job.waitForCompletion(true) ? 0 : 1);
//     }
// }
//
// class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
//     private Text k = new Text();
//     private IntWritable v = new IntWritable(1);
//
//     @Override
//     protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//         String line = value.toString();
//         String[] words = line.split(" ");
//         for (String word : words) {
//             k.set(word);
//             context.write(k, v);
//         }
//     }
// }
//
// class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
//     private IntWritable v = new IntWritable();
//
//     @Override
//     protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
//         int sum = 0;
//         for (IntWritable count : values) {
//             sum += count.get();
//         }
//         v.set(sum);
//         context.write(key, v);
//     }
// }
//
