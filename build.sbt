name := "GTFS"

version := "1.0"

scalaVersion := "2.12.3"

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

// https://mvnrepository.com/artifact/com.google.transit/gtfs-realtime-bindings
libraryDependencies += "com.google.transit" % "gtfs-realtime-bindings" % "0.0.4"

// https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.11.0.1"
