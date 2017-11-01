create table if not exists street_crime ( crimeid string, themonth string, report_by string, falls_in string, longitude DOUBLE, latitude DOUBLE, location string, LSOAcode string, LSOAname string, crime_type string, last_outcome string, the_context string) 
row format delimited fields terminated by ',' 
stored as textfile;

load data local inpath '/home/hduser/zdata/uk-crime/spark-lake/staging/' into table street_crime;
-- select count(*) from crimeavon1;
select report_by, LSOAcode, crime_type, last_outcome from street_crime limit 20;

