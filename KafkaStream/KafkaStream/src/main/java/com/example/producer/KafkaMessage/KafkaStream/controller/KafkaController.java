package com.example.producer.KafkaMessage.KafkaStream.controller;


import com.example.producer.KafkaMessage.KafkaStream.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    private KafkaService kafkaService;
    @GetMapping(
            path="stream/start"
    )
    public ResponseEntity publish(){
        System.setProperty("streamState","Start");
        Boolean isvalid =kafkaService.publishMessage();
        return ResponseEntity.ok("Published Successfully :: "+ isvalid);
    }


    @GetMapping(
            path="stream/stop"
    )
    public ResponseEntity stopStream(){
        System.setProperty("streamState","Stop");
     //   kafkaService.startStream();
        return ResponseEntity.ok("Streaming Started. click http://localhost:9021/clusters/:: ");
    }

}
