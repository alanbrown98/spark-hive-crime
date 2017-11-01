/* DemoHive.java */
/*
 *  2017-10-08
 *
 *  Hive Tables 
 *      
 */
import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;

// for sql
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import scala.Tuple2; 
import org.apache.spark.api.java.JavaPairRDD; 
import org.apache.spark.api.java.JavaRDD; 
import org.apache.spark.api.java.JavaSparkContext; 
import org.apache.spark.api.java.function.FlatMapFunction; 
import org.apache.spark.api.java.function.Function2; 
import org.apache.spark.api.java.function.PairFunction; 

 
import java.io.FileReader; 
import java.util.Arrays; 
import java.util.List; 
import java.util.regex.Pattern; 
import java.util.ArrayList;

//
import java.util.Collections;
import java.io.Serializable;

import org.apache.spark.api.java.function.MapFunction;

import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;

import static org.apache.spark.sql.functions.col;

public class DemoHive {
  public static void main(String[] args) throws Exception {

// warehouseLocation points to the default location for managed databases and tables
String warehouseLocation = "file:" + System.getProperty("user.dir") + "/" + "spark-warehouse";   
    System.out.println("----------------------------------------------------");
    System.out.println("user-dir= " + System.getProperty("user.dir"));
    System.out.println(warehouseLocation);
    System.out.println("----------------------------------------------------");
SparkSession spark = SparkSession
  .builder()
  .appName("Java Spark Hive Example")
  .config("spark.sql.warehouse.dir", warehouseLocation)
  .enableHiveSupport()
  .getOrCreate();

// Queries are expressed in HiveQL

spark.sql("select searchtype, searchdate, gender, age_range, object_of_search, outcome FROM stop_and_search LIMIT 10").show();

spark.sql("DESC stop_and_search").show();

spark.sql("select searchtype, searchdate, gender, age_range, object_of_search, outcome FROM stop_and_search ORDER BY age_range LIMIT 10").show();
 
     System.out.println("----------------------------------------------------");
    System.out.println("user-dir= " + System.getProperty("user.dir"));
    System.out.println(warehouseLocation);
    System.out.println("----------------------------------------------------");
    
  System.out.println("----------------------------------");
  System.out.println("Done ...");
  System.out.println("----------------------------------");
        
  }
}

// enzomele83@gmail.com
