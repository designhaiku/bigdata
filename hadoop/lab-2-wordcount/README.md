

Details for all of the packages for maven within CDH
    https://ccp.cloudera.com/display/CDH4DOC/Using+the+CDH4+Maven+Repository


#Let's explore

*Goal #1:  verify word count version 2 setup
Execute: hadoop fs -ls /projects/wordcount/input/
- /projects/wordcount/input/file01
    "Hello World, Bye World!"

- /projects/wordcount/input/file02
    "Hello Hadoop, Goodbye to hadoop."

Execute: hadoop jar hadoop-wordcount-1.0-SNAPSHOT-job.jar \
        /projects/wordcountv2/input \
        /projects/wordcountv2/output

Execute: hadoop fs -cat /projects/wordcount/output/part*

