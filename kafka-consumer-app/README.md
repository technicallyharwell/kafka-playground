# kafka-consumer-app

## Setup
- create a topic by exec into broker container and `kafka-topics --create --topic input-topic --bootstrap-server broker:9092 --replication-factor 1 --partitions 1`

## Notes
- We interface to `ConsumerRecords` with `ConsumerRecordsHandler`
  - This allows for more flexible interactions with `ConsumerRecords` and easier testing without having to change the code
- `MockConsumer` utilized to prevent the need for a running Kafka cluster during testing