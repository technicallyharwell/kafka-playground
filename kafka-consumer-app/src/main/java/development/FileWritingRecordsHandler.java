package developer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class FileWritingRecordsHandler implements ConsumerRecordsHandler<String, String> {

    private final Path path;

    public FileWritingRecordsHandler(final Path path) {
        this.path = path;
    }

    @Override
    public void process(final ConsumerRecords<String, String> consumerRecords) {
        final List<String> valueList = new ArrayList<>();
        /*In a real world application, this is where the meaty business logic for
        * processing individual records from Kafka would go*/
        consumerRecords.forEach(record -> valueList.add(record.value()));
        if (!valueList.isEmpty()) { // consumer has
            try {
                Files.write(path, valueList, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
