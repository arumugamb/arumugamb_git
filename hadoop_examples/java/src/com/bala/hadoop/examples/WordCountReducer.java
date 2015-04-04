package com.bala.hadoop.examples;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

	@Override
	public void reduce(Text key, Iterable<LongWritable> values, Context context)
			throws IOException, InterruptedException {
		Long count = 0L;
		for (LongWritable lw : values) {
			count++; // Instead of count++, you can use count += lw.get(); as
						// well.
		}
		context.write(key, new LongWritable(count));
	}
}