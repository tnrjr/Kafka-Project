package br.com.tary.consumerkafka.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {

    @KafkaListener(topics = "tary-topic", groupId = "myGroup")
    public void listener(String data){
        System.out.println("-------------------------------------------------------------");
        System.out.println(String.format("{Consumer} - Mensagem recebida: %s \n", data));
    }
}
