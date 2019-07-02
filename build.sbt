name := "spark_test"

version := "0.1"

scalaVersion := "2.11.12"

val sparkVersion = "2.3.0"

resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.kafka" % "kafka-clients" % "0.10.1.0",
  "org.apache.spark" %% "spark-sql-kafka-0-10" % sparkVersion,
  "org.apache.spark" % "spark-streaming-kafka-0-10_2.11" % "2.1.0",
"mysql" % "mysql-connector-java" % "5.1.6"
)