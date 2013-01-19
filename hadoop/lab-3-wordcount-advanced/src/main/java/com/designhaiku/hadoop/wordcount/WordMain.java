package com.designhaiku.hadoop.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.ToolRunner;

/**
 * User: Jeffrey M Lutz <jeff@lutz.ws>
 * Date: 1/18/13
 */
public class WordMain extends Configured {

    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new WordTool(), args);
        System.exit(res);
    }
}
