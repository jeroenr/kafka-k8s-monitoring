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
  // TODO: consume orders and do something useful with it
}
