package br.com.tary.producerkafka.producer;

import br.com.tary.producerkafka.dto.UsuarioRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, UsuarioRequest> kafkaTemplate;
    private static final String TOPIC = "tary-topic";

    public KafkaProducer(KafkaTemplate<String, UsuarioRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(UsuarioRequest request){
        Message<UsuarioRequest> message = MessageBuilder
                .withPayload(request)
                .setHeader(KafkaHeaders.TOPIC, TOPIC)
                .build();

        System.out.println("{Producer} Mensagem enviada.");
        kafkaTemplate.send(message);
    }
}
