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
  id: Option[Int],
  country: Option[String],
  points: Option[Int],
  price: Option[Double],
  title: Option[String],
  variety: Option[String],
  winery: Option[String]
)
