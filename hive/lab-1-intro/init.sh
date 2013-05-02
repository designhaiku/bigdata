#!/bin/bash

echo Inializing HDFS
hadoop fs -mkdir /user/hive/tmp

echo Creating table and loading data into TABLE: grade
hive -f create_table.ddl

echo Run:  hive and call the select * from grade
