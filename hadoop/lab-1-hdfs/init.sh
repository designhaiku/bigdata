#!/bin/bash

hadoop fs -rm -r ./hdfs
hadoop fs -mkdir -p ./hdfs/haystack1
hadoop fs -mkdir -p ./hdfs/haystack2
hadoop fs -mkdir -p ./hdfs/haystack3
hadoop fs -mkdir -p ./hdfs/haystack4
hadoop fs -mkdir -p ./hdfs/haystack5
hadoop fs -mkdir -p ./hdfs/haystack6
hadoop fs -mkdir -p ./hdfs/haystack7
hadoop fs -mkdir -p ./hdfs/haystack8
hadoop fs -mkdir -p ./hdfs/haystack9
hadoop fs -mkdir -p ./hdfs/haystack10
hadoop fs -put README.md ./hdfs/haystack5/needle
