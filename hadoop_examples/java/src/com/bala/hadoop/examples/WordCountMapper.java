package com.bala.hadoop.examples;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String words[] = line.split("\\s");

		for (int i = 0; i < words.length; i++) {
			String word = words[i].trim();
			if (word.length() > 0) {
				context.write(new Text(word), new LongWritable(1));
			}
		}
	}
}