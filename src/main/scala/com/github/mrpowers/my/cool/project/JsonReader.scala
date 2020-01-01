package com.github.mrpowers.my.cool.project
import org.apache.spark.sql.SparkSession
import org.json4s._
import org.json4s.jackson.JsonMethods._

object JsonReader extends App {

  val spark = SparkSession.builder().master("local").getOrCreate()
  val sc = spark.sparkContext
  implicit val formats = DefaultFormats

  val filepath = args(0)

  sc.textFile(filepath)
    .map(parse(_).extract[Wine])
    .collect()
    .foreach{println _}
}

case class Wine(
  id: Option[Int] = None,
  country: Option[String] = None,
  points: Option[Int] = None,
  price: Option[Double] = None,
  title: Option[String] = None,
  variety: Option[String] = None,
  winery: Option[String] = None
)
