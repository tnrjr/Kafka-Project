package br.com.tary.producerkafka.controller;

import br.com.tary.producerkafka.producer.KafkaProducer;
import br.com.tary.producerkafka.dto.UsuarioRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/users")
public class UsuarioController {

    private final KafkaProducer producer;

    public UsuarioController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/new")
    public ResponseEntity<String> newUser(@RequestBody UsuarioRequest request){
        producer.send(request);
        return new ResponseEntity<>("Usuário criado", HttpStatus.CREATED);
    }

}
