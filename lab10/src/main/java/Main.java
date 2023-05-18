import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.SparkSession.*;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
public class Main {
  public static void main(String[] args) {
    SparkConf conf = new SparkConf().setAppName("Lab10");
    JavaSparkContext sc = new JavaSparkContext(conf);
    SparkSession spark = SparkSession.builder().appName("Lab10").getOrCreate();
    Dataset<Row> csv = spark.read().format("csv").option("header", "true").load("russian_demography.csv");
    csv.createOrReplaceTempView("demography");

    spark.sql("select * from demography limit 10").show();
    spark.sql("select year, min(birth_rate)\n" +
		   "from demography\n" +
		   "group by year\n" +
		   "order by year"
    ).show();
    spark.sql("select count(*) from demography").show();
    spark.sql("select region, count(region) from demography group by region").show();
    spark.sql("select region, avg(death_rate), avg(birth_rate) from demography group by region").show();
    spark.sql("select region, urbanization from demography where urbanization is not null order by urbanization").show();
    spark.sql("select year, region from demography where npg > 1").show();
    spark.sql("select year, sum(npg) as sum_npg from demography group by year having sum_npg > 100").show();
    spark.sql("select region, avg(gdw) as avg_gdw from demography group by region having avg_gdw > 10").show();
    spark.sql("select region, max(gdw) as max_gdw from demography group by region having max_gdw >= 90").show();
    
    sc.stop();
  }
}
