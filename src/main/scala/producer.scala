import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer


class Producer(topic: String, brokers: String) {

  val producer = new KafkaProducer[String, String](configuration)

  private def configuration: Properties = {
    val props = new Properties()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers)
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getCanonicalName)
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getCanonicalName)
    props
  }

  //  def sendMessages(): Unit = {
  //    println("Enter message (type exit to quit)")
  //    var message = StdIn.readLine()
  //
  //    while (! message.equals("exit")) {
  //      val record = new ProducerRecord[String, String](topic, "1", message)
  //      producer.send(record)
  //      message = StdIn.readLine()
  //    }
  //
  //    producer.close()
  //  }

  def sendMessages(): Unit = {
    println("Fetching daa from api")

    while (true) {
      val r = requests.get("https://api.iextrading.com/1.0/stock/BABA/relevant")
      val data = ujson.read(r.text)
      //      works
      //      val message = data("symbols").toString()
      val message = data("symbols").arr.map(_.toString().replaceAll("\"", "")).mkString(",")
      //      val message = data("symbols").arr.mkString(",")

      val record = new ProducerRecord[String, String](topic, "1", message)
      producer.send(record)
    }

    producer.close()
  }


}

object Producer extends App {

  val producer = new Producer(brokers = "localhost:9092", topic = "test")
  producer.sendMessages()

}