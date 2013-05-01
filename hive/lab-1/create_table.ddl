DROP TABLE grade;

CREATE TABLE grade(name STRING, ssn STRING, grade FLOAT)
COMMENT 'Actual grade table'
STORED AS SEQUENCEFILE;

INSERT INTO grade
   SELECT concat(firstname,lastname), ssn, grade from students;

LOAD DATA LOCAL INPATH '/tmp/grade-data.txt' OVERWRITE INTO TABLE grade;

