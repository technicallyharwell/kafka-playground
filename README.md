# kafka-playground
Playground space for tinkering with and learning about Kafka

## Index
- kafka-producer-app : Reads from `input.txt` and writes to local topic
- kafka-consumer-app : Reads from local topic and writes to `consumer-records.out`


### General Notes
- Wrapping the producer/consumer classes allows for easier testing via mocks

#### Producer Setup
- Constructed with a `producer` instance and the topic to push to

#### Consumer Setup
- Constructed with a `consumer` instance and a `RecordsHandler`


### Java Takeaways
- `volatile` keyword declares that value may be modified by different threads
    - Ensures that all threads see the most up-to-date value **visibility**
    - **Atomic** read and write operations 
    - Compiler **ordering** of operations to sync threads and help prevent race conditions
