package com.xebia.orders

import akka.Done
import akka.actor.ActorSystem
import akka.kafka.scaladsl._
import akka.kafka._
import akka.stream.{ActorMaterializer, Materializer}
import akka.stream.scaladsl.Sink
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization._

object OrderConsumer extends App {

  private implicit val actorSystem = ActorSystem("orders")
  implicit val mat: Materializer = ActorMaterializer()
  implicit val ec = actorSystem.dispatcher

  val settings = ConsumerSettings(actorSystem, new StringDeserializer, new ByteArrayDeserializer)
    .withBootstrapServers("kafka:9092")
    .withGroupId("my-group")
    .withProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

  Consumer.plainSource(settings, Subscriptions.topics("orders"))
    .map(_.value())
    .map(new String(_))
    .map(println)
    .runWith(Sink.ignore).onComplete {
      _ =>
        println("Stream is dead!")
        sys.exit(1)
    }


}
