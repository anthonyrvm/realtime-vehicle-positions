import java.net.URL
import java.time.LocalDateTime
import java.util.Properties

import com.google.transit.realtime.GtfsRealtime.FeedMessage
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import collection.JavaConverters._
import scala.util.Random


object GTFSRealtime extends App {

    val url = new URL("http://gtfs.ovapi.nl/nl/vehiclePositions.pb")
    val feed = FeedMessage.parseFrom(url.openStream)

     println( feed.getEntityList.asScala.map(entity => Some(entity.getVehicle)).count(_ => true))


//    val events = args(0).toInt
//    val topic = args(1)
//    val brokers = args(2)
//    val rnd = new Random()
//    val props = new Properties()
//    props.put("bootstrap.servers", brokers)
//    props.put("client.id", "ScalaProducerExample")
//    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
//    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
//
//
//    val producer = new KafkaProducer[String, String](props)
//    val t = System.currentTimeMillis()
//    for (nEvents <- Range(0, events)) {
//        val runtime = LocalDateTime.now()
//        val ip = "192.168.2." + rnd.nextInt(255)
//        val msg = runtime + "," + nEvents + "localhost:" + ip
//        println(msg)
//        val data = new ProducerRecord[String, String](topic, ip, msg)
//
//        //async
//        //producer.send(data, (m,e) => {})
//        //sync
//        producer.send(data)
//    }
//
//    println("sent per second: " + events * 1000 / (System.currentTimeMillis() - t))
//    producer.close()
}




