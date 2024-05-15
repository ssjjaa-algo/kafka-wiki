package kafka.wiki.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaWikiProducerApplication implements CommandLineRunner {

	// CommandLineRunner : Spring이 구동될 때 특정 코드 실행

	public static void main(String[] args) {
		SpringApplication.run(KafkaWikiProducerApplication.class, args);
	}


	private final WikimediaChangeProducer wikimediaChangeProducer;

	public KafkaWikiProducerApplication(WikimediaChangeProducer wikimediaChangeProducer) {
		this.wikimediaChangeProducer = wikimediaChangeProducer;
	}

	@Override
	public void run(String... args) throws Exception {
		wikimediaChangeProducer.sendMessage();
	}


}
