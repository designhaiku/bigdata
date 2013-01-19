package com.designhaiku.hadoop.columnsum;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

/**
 * User: Jeffrey M Lutz <jeff@lutz.ws>
 * Date: 1/18/13
 */
public class ColumnSumReducer extends MapReduceBase implements Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {

    public void reduce(IntWritable column, Iterator<IntWritable> values, OutputCollector<IntWritable, IntWritable> output, Reporter reporter) throws IOException {
        // Do something awesome!
    }
}
