--
--   load stop and search uk crime data
--

create table if not exists stop_and_search (
  searchType STRING, searchDate STRING, part_police_operation STRING, police_operation STRING, latitude DOUBLE, longitude DOUBLE, gender STRING, age_range STRING, self_define_ethnicity STRING, officer_defined_ethnicity STRING, legislation STRING, object_of_search STRING, outcome STRING, outcome_linked_to_object STRING, removal_clothing STRING
)


row format delimited fields terminated by ',' 
stored as textfile;
load data local inpath '/home/hduser/zdata/uk-crime/spark-lake/staging/' into table stop_and_search;
 
select * from stop_and_search limit 10;