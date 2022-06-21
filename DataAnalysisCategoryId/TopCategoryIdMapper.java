package TopCategoryId;

import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class TopCategoryIdMapper extends MapReduceBase implements Mapper <LongWritable, Text, Text, IntWritable> {
	private final static IntWritable one = new IntWritable(1);
    private Text category = new Text();
	public void map(LongWritable key, Text value, OutputCollector <Text, IntWritable> output, Reporter reporter) throws IOException {

		String line = value.toString();
		String[] str = line.split(",");
		System.out.println(Arrays.toString(str));
        if(str.length>5)
        {
            category.set(str[6]);
        }

        output.collect(category, one);

	}
}
