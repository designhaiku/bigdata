Streaming 101:

   "hadoop jar /usr/lib/hadoop-mapreduce/hadoop-streaming-2.0.0-cdh4.1.2.jar -input /some/in-dir -output /some/out-dir -mapper <some-cmd> -reducer <some-cmd>"

Example: " hadoop jar /usr/lib/hadoop-mapreduce/hadoop-streaming-2.0.0-cdh4.1.2.jar -input /projects/wordcount/input -output /projects/wordcount/output -mapper /bin/cat -reducer /bin/wc"
