package cn.iktz.hadoop;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {

	public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {

		private final static IntWritable one = new IntWritable(1);
		private Text word = new Text();

		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
//			System.out.println(value.toString());
			StringTokenizer itr = new StringTokenizer(value.toString());
			while (itr.hasMoreTokens()) {
//				System.out.println(itr.nextToken());
				String nextToken = itr.nextToken();
				
//				System.out.println(nextToken);
				if(nextToken.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")){
					word.set(nextToken);
					context.write(word, one);
				}
				
			}
		}
	}
	static String remote = "hdfs://192.168.1.211:9000/a222";
	static String out = "hdfs://192.168.1.211:9000/out";
	
	public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		private IntWritable result = new IntWritable();

		public void reduce(Text key, Iterable<IntWritable> values, Context context)
				throws IOException, InterruptedException {
			
			int sum = 0;
			for (IntWritable val : values) {
				System.out.println(val.toString());
				sum += val.get();
			}
			System.out.println(key.toString());
			System.out.println(sum +"    "+ key.toString());
			result.set(sum);
			context.write(key, result);
		}
	}

	public static void main(String[] args) throws Exception {
		
		
		
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "word count");
		job.setJarByClass(WordCount.class);
		job.setMapperClass(TokenizerMapper.class);
		job.setCombinerClass(IntSumReducer.class);
		job.setReducerClass(IntSumReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path(remote));
		FileOutputFormat.setOutputPath(job, new Path(out));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}