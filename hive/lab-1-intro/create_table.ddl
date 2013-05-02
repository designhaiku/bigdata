set hive.exec.scratchdir=/user/hive/tmp;

DROP TABLE IF EXISTS grade;

CREATE TABLE grade(name STRING, ssn STRING, grade FLOAT)
COMMENT 'Actual grade table'
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

LOAD DATA LOCAL INPATH 'grade-data.txt' OVERWRITE INTO TABLE grade;

