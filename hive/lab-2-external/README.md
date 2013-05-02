CREATE EXTERNAL TABLE students(lastname STRING,firstname STRING,ssn STRING,grade FLOAT,notes STRING)
COMMENT 'This is a staging table'
ROW FORMAT DELIMITED FIELDS TERMINATED BY '44' LINES TERMINATED BY '10'
STORED AS TEXTFILE
LOCATION '/projects/hiveintro';


Custom SerDe for handling xml / json

UDTF ; User defined table-defining function
UDAF : User defined aggregate function


Example:  A field with a url virtual path:
 https://google.com/my/first/directory/file.html

 field 4:  /my/first/directory/file.html

Url Entropy calc:

field 5:  0.5 (float) computed from field 4

select field4 entropy(field4) as field5 where field5 > 0.6;

