# kafka_spark

export PATH="/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin:$PATH" 
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home


bin/zookeeper-server-start.sh config/zookeeper.propertiescd

bin/kafka-server-start.sh config/server.properties

bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test

bin/kafka-topics.sh --list --bootstrap-server localhost:9092

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning

./spark-2.3.3-bin-hadoop2.7/bin/spark-submit --master local[2] --class peisong.liu.spark.DirectKafkaWordCount target/scala-2.11/spark_test_2.11-0.1.jar --jars jars/kafka-clients-0.10.0.1.jar,jars/spark-streaming-kafka-0-10_2.11-2.3.0.jar localhost:9092 1 test
