package com.agileanswers.hadoop.lab4;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class InverseIndexDriver extends Configured implements Tool {

    public int run(String[] args) throws Exception {
// create JobConf object, configure it,
// then use JobClient.runJob(conf) to submit the job

        JobConf conf = new JobConf(InverseIndex.class);
        conf.setJobName("com.agileanswers.hadoop.lab4.InverseIndex");

        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        conf.setInputFormat(KeyValueTextInputFormat.class);

        conf.setMapperClass(InverseIndexMapper.class);
        conf.setReducerClass(InverseIndexReducer.class);

        conf.setMapOutputKeyClass(Text.class);
        conf.setMapOutputValueClass(IntWritable.class);

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        JobClient.runJob(conf);

        return 0;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: com.agileanswers.hadoop.lab4.InverseIndex <input dir> <output dir>");
            System.exit(-1);
        }

        int exitCode = ToolRunner.run(new InverseIndexDriver(), args);
    }
}
