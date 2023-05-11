package com.refinitiv.stream.compliance.processor.ComplianceProcessor.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.refinitiv.stream.compliance.processor.ComplianceProcessor.dto.Message;
import org.springframework.integration.support.json.JsonObjectMapper;

public class GenericUtil {
    private static final ObjectMapper jsonObjectMapper;
    static {
        jsonObjectMapper= new ObjectMapper();
    }
    public static Message ConstructMessageFromJson(String msgString) throws JsonProcessingException {
        return jsonObjectMapper.readValue(msgString,Message.class);

    }

    public static String DeconstructMessageToString(Message message) throws JsonProcessingException {
        return jsonObjectMapper.writeValueAsString(message);
    }
}
