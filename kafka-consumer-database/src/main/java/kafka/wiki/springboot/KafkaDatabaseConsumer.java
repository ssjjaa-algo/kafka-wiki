package kafka.wiki.springboot;

import kafka.wiki.springboot.entity.WikimediaData;
import kafka.wiki.springboot.repository.WikimediaRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private final WikimediaRepository wikimediaRepository;

    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId = "myGroup"
    )
    public void consume(String eventMessage) {
        LOGGER.info("Event Message received: {}", eventMessage);

         WikimediaData wikimediaData = new WikimediaData();
         wikimediaData.setWikiEventData(eventMessage);

         wikimediaRepository.save(wikimediaData);
    }
}
