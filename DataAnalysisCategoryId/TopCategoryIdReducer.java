package TopCategoryId;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class TopCategoryIdReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {

	public void reduce(Text t_key, Iterator<IntWritable> values, OutputCollector<Text,IntWritable> output, Reporter reporter) throws IOException {
		Text key = t_key;
		int frequency = 0;
		while (values.hasNext()) {
			
			IntWritable value = (IntWritable) values.next();
			frequency += value.get();
			
		}
		output.collect(key, new IntWritable(frequency));
	}
}