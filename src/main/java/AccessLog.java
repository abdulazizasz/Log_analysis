import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.conf.*;
public class AccessLog {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: Access_log <input path> <output path>");
      System.exit(-1);
    }

    Configuration conf = new Configuration();
    Job job = new Job(conf);
    job.setJarByClass(AccessLog.class);
    job.setJobName("AccessLog");

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    job.setMapperClass(AccessLogMapper.class);
    job.setReducerClass(AccessLogReducer.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}