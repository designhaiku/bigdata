package com.designhaiku.hadoop.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

/**
 * User: Jeffrey M Lutz
 * Date: 8/28/12
 */
public class MyCount implements Mapper<Object, Text, Text, IntWritable> {
    @Override
    public void map(Object o, Text text, OutputCollector<Text, IntWritable> textIntWritableOutputCollector, Reporter reporter) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void close() throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void configure(JobConf entries) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
