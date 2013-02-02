package com.agileanswers.hadoop.lab4;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.StringTokenizer;

public class InverseIndexMapper extends MapReduceBase
        implements Mapper<Object, Text, Text, Text> {


    public void map(Object inputKey, Text inputText, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

        // Break line into words for processing
        StringTokenizer wordList = new StringTokenizer(inputText.toString());

        Text keyText = new Text();
        Text wordText = new Text();

        keyText.set(inputKey.toString());

        while (wordList.hasMoreTokens()) {
            String word = wordList.nextToken();
            wordText.set(word);
            output.collect(wordText, keyText);
        }
    }
}
