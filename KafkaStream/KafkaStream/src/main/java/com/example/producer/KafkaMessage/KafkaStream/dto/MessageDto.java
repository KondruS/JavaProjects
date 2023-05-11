package com.example.producer.KafkaMessage.KafkaStream.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto {
    private String chatRoomId;
    private String messageId;
    private String createAt;
    private String messageType;
    private String message;
    private String attachmentReference;
    private String userId;
}
