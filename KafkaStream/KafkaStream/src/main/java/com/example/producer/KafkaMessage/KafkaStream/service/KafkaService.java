package com.example.producer.KafkaMessage.KafkaStream.service;

import com.example.producer.KafkaMessage.KafkaStream.dto.MessageDto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service

public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Boolean publishMessage() {
        List<String> chatRoomId= Arrays.asList("blc:123","blc:3456","blc:7890","blc:7890","blc:1470","blc:2850","blc:3690","blc:2150","blc:3650");
        List<String> messageId= Arrays.asList("1619085847023:c2b3","1619085847023:a2b3","1619085847023:b2b3","1619085847023:d2b3","1619085847023:e2b3","1619085847023:f2b3","1619085847023:g2b3","1619085847023:h2b3","1619085847023:i2b3");

        String messageType= "text/plain";
        List<String> message= Arrays.asList("hello guys","To the moon","Infinity and beyond","May the force be with you","up up and away","<My ninja Path>","hell yeahhh","Kane is coming","Multiverse is no joke");
       String attachmentReference= "https://awsendpoint.com/download/123132";
        List<String> userId= Arrays.asList("uuid#123","uuid#345","uuid#678","uuid#901","uuid#234","uuid#567","uuid#890","uuid#089","uuid#765");
        ObjectMapper mapper = new ObjectMapper();
        String msgString="";
        while("Start".equalsIgnoreCase(System.getProperty("streamState"))){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String rchatRoomId=chatRoomId.get(new Random().nextInt(chatRoomId.size()));
            String rmessageId=messageId.get(new Random().nextInt(messageId.size()));
            String rmessage=message.get(new Random().nextInt(message.size()));
            String ruserId=userId.get(new Random().nextInt(userId.size()));
            MessageDto messageDto = MessageDto.builder()
                    .chatRoomId(rchatRoomId)
                    .messageId(rmessageId)
                    .createAt(String.valueOf(LocalTime.now()))
                    .messageType(messageType)
                    .message(rmessage)
                    .attachmentReference(attachmentReference)
                    .userId(ruserId)
                    .build();
            try {
                 msgString= mapper.writeValueAsString(messageDto);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            log.info("Publishin Message :: "+msgString);
            kafkaTemplate.send("compliance.msg.in.new", UUID.randomUUID().toString(),msgString);

        }
        return true;
    }
}
