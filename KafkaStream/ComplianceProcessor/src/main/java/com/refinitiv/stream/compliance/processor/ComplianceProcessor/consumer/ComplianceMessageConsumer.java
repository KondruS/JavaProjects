package com.refinitiv.stream.compliance.processor.ComplianceProcessor.consumer;

import com.refinitiv.stream.compliance.processor.ComplianceProcessor.Service.ACMEService;
import com.refinitiv.stream.compliance.processor.ComplianceProcessor.dto.Message;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.streams.kstream.KStream;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerde;

@Configuration
public class ComplianceMessageConsumer {
    @Autowired
    private ACMEService acmeService;
    private KafkaTemplate kafkaTemplate;

    @Bean
    public Function<KStream<String, String>, KStream<String, String>> complianceValidator() {
           return kStream->kStream
                .peek((k, v) -> System.out.println("Message : " + v))
                 .mapValues(v-> acmeService.validateMessage(v));
    }

    @Bean
    public Serde<Message> messageSerde(){
        return new JsonSerde<>();
    }



}
