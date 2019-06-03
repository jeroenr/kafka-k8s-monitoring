name := "order-consumer"
organization := "com.xebia"
scalaVersion := "2.12.1"

libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "1.0.3"

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
dockerBaseImage := "openjdk:11-jre-slim"
dockerRepository := Some("jeroenrosenberg")
