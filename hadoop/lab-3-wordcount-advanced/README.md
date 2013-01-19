

Details for all of the packages for maven within CDH
    https://ccp.cloudera.com/display/CDH4DOC/Using+the+CDH4+Maven+Repository


#Let's explore

*Goal #1:  verify word count version 2 setup
Execute: hadoop fs -ls /projects/wordcountv2/input/
- /projects/wordcountv2/input/file01
    "Hello World, Bye World!"

- /projects/wordcountv2/input/file02
    "Hello Hadoop, Goodbye to hadoop."

Execute: hadoop jar hadoop-wordcount-1.0-SNAPSHOT-job.jar \
        /projects/wordcountv2/input \
        /projects/wordcountv2/output

Execute: hadoop fs -cat /projects/wordcountv2/output/part*


*Goal #2:  Let's demo the distributed cache mechanism for small / read-only data

Execute:  hadoop fs -cat /projects/wordcountv2/patterns.txt
    "\."
    "\,"
    "\!"
    "to"

Execute: hadoop jar hadoop-wordcount-1.0-SNAPSHOT-job.jar \
        -Dwordcount.case.sensitive=true \
        /projects/wordcountv2/input \
        /projects/wordcountv2/output \
        -skip /projects/wordcountv2/patterns.txt

