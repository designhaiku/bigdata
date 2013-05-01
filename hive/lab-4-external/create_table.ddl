CREATE EXTERNAL TABLE students(lastname STRING,firstname STRING,ssn STRING,grade FLOAT,notes STRING)
COMMENT 'This is a staging table'
ROW FORMAT DELIMITED FIELDS TERMINATED BY '44' LINES TERMINATED BY '12'
STORED AS TEXTFILE
LOCATION '/projects/hiveintro';


CREATE TABLE grade(name STRING, ssn STRING, grade FLOAT)
COMMENT 'Actual grade table'
STORED AS SEQUENCEFILE;

INSERT INTO grade
   SELECT concat(firstname,lastname), ssn, grade from students;
