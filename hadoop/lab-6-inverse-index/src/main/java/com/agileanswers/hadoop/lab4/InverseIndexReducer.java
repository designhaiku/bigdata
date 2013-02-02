package com.agileanswers.hadoop.lab4;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

public class InverseIndexReducer extends MapReduceBase
        implements Reducer<Text, Text, Text, Text> {



    private Text valueText = new Text();

    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

        StringBuilder sb = new StringBuilder();
        while (values.hasNext()) {
            sb.append(values.next());
            if(values.hasNext()) {
                sb.append(", ");
            }
        }
        valueText.set(sb.toString());
        output.collect(key, valueText);
    }
}
