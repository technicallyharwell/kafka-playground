# kafka-streams-app
A stream processing topology defines the business logic that interacts with a stream
  - `stream` utilized for reading events from an input topic
  - `mapValues` transforms the values of each event
  - `peek` allows for logging of each event
  - `to` writes the events to an output topic

`processor topology` - directed graph of processors (nodes) and edges (streams) that define the flow of data from 
input topics to output topics. Two implementation methods are:
1. `Streams DSL` - high-level API that allows for the creation of processing concepts e.g. `streams`, `tables`, `transformations`
2. `Processor API` - low-level API that allows for the creation of custom processors and state stores

This project utilizes `Streams DSL`

`CountDownLatch` from `util.concurrent` allows for the main thread to wait for the Kafka Streams application to shutdown
  - `latch.countDown()` decrements the count of the latch, allowing the main thread to continue
  - `latch.await()` blocks the main thread until the latch count reaches 0
  - We initiate the latch with a count of 1, and use it to block the thread while the stream is active

## Usage
- launch docker-compose
- `./gradlew shadowJar`
- `java -jar build/libs/creating-first-apache-kafka-streams-application-*.jar configuration/dev.properties`


## Contents
`Util.java` - contains utility methods for interacting with Kafka e.g. generating topics and sample event data




### Results



