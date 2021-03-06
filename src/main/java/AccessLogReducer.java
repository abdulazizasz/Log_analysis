import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AccessLogReducer
    extends Reducer<Text, IntWritable, Text, IntWritable> {
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
    
    if(key.equals(new Text("10.153.239.5"))) {

       int sum = 0;
    for (IntWritable value : values) {
      sum += value.get();
    }

    
        context.write(key, new IntWritable(sum));
        
    }
   
    
    
  }
}