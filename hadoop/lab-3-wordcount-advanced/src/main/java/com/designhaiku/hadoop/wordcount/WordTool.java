package com.designhaiku.hadoop.wordcount;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.Tool;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jeffrey M Lutz <jeff@lutz.ws>
 * Date: 1/18/13
 */
public class WordTool extends Configured implements Tool {

    @Override
    public int run(String[] args) throws Exception {
        JobConf conf = new JobConf(getConf(), WordMain.class);
        conf.setJobName("wordcountv2");
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        conf.setMapperClass(WordMapper.class);
        conf.setCombinerClass(WordReducer.class);
        conf.setReducerClass(WordReducer.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
        List<String> other_args = new ArrayList<String>();
        for (int i = 0; i < args.length; ++i) {
            if ("-skip".equals(args[i])) {
                DistributedCache.addCacheFile(new Path(args[++i]).toUri(), conf);
                conf.setBoolean("wordcount.skip.patterns", true);
            } else {
                other_args.add(args[i]);
            }
        }
        FileInputFormat.setInputPaths(conf, new Path(other_args.get(0)));
        FileOutputFormat.setOutputPath(conf, new Path(other_args.get(1)));
        JobClient.runJob(conf);
        return 0;
    }
}
