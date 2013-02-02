package com.agileanswers.hadoop.lab4;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;

public class InverseIndex {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: com.agileanswers.hadoop.lab4.InverseIndex <input dir> <output dir>");
            System.exit(-1);
        }

        JobConf conf = new JobConf(InverseIndex.class);
        conf.setJobName("com.agileanswers.hadoop.lab4.InverseIndex");

        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        conf.setInputFormat(KeyValueTextInputFormat.class);

        conf.setMapperClass(InverseIndexMapper.class);
        conf.setReducerClass(InverseIndexReducer.class);

        conf.setMapOutputKeyClass(Text.class);
        conf.setMapOutputValueClass(Text.class);

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);

        JobClient.runJob(conf);
        System.exit(0);
    }
}
