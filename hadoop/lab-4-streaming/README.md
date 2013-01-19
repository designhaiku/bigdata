Streaming 101:

   "hadoop jar /usr/lib/hadoop-mapreduce/hadoop-streaming.jar -input /some/in-dir -output /some/out-dir -mapper <some-cmd> -reducer <some-cmd>"

Example: " hadoop jar /usr/lib/hadoop-mapreduce/hadoop-streaming.jar -input /projects/wordcount/input -output /projects/wordcount/output -mapper /bin/cat -reducer /bin/wc"
