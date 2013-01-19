package com.designhaiku.hadoop.columnsum;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Jeffrey M Lutz <jeff@lutz.ws>
 * Date: 1/18/13
 */
public class ColumnSumMapper extends MapReduceBase implements Mapper<LongWritable, Text, IntWritable, IntWritable> {

    static enum Counters {INPUT_COLUMNS}

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
    private boolean caseSensitive = true;
    private Set<String> patternsToSkip = new HashSet<String>();
    private long numRecords = 0;
    private String inputFile;

    public void configure(JobConf job) {
// do something awesome
    }

    @Override
    public void map(LongWritable longWritable, Text text, OutputCollector<IntWritable, IntWritable> intWritableIntWritableOutputCollector, Reporter reporter) throws IOException {
// do something awesome
    }
}
