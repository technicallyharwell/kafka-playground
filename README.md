# kafka-playground
A local implementation of Kafka using confluent cli to bootstrap

## Usage

- exec `kafka-topics --create --topic output-topic --bootstrap-server broker:9092 --replication-factor 1 --partitions 1` in broker container
  - this creates a topic called `output-topic` with 1 partition and 1 replica
  - this is the topic that the producer will write to and the consumer will read from
  - keep the terminal open to validate producer/consumer interactions

- `gradle wrapper`

- build uberjar `./gradlew shadowJar`
- run producer `java -jar build/libs/kafka-producer-application-standalone-0.0.1.jar configuration/dev.properties input.txt`

- run tests with `./gradlew test`

## Properties Reference
[kafka acks](https://kafka.apache.org/documentation/#acks) :
- 0: producer will not wait for any acknowledgment from the server at all
- 1: producer will receive acknowledgment after the leader replica has received the data
- all: producer will receive acknowledgment after all in-sync replicas have received the data

[full config list](https://kafka.apache.org/documentation/#producerconfigs) 


### Results

- consuming messages produced to the topic:

> [appuser@broker ~]$ kafka-console-consumer --topic output-topic --bootstrap-server broker:9092 \
>  --from-beginning \
>  --property print.key=true \
>  --property key.separator=" : "
1 : value
2 : words
3 : All Streams
4 : Lead to
5 : Kafka
6 : Go to
7 : Kafka Summit
8 : How can
9 : a 10 ounce
10 : bird carry a
11 : 5lb coconut
12 : It could grip
13 : it by the
14 : husks
15 : It's not a
16 : question of
17 : where he
18 : grips it
19 : It's a simple
20 : question of
21 : weight ratios
22 : A 5 ounce
23 : bird could
24 : not carry a
25 : 1lb coconut
^CProcessed a total of 25 messages



