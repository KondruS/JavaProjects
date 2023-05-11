package com.refinitiv.stream.compliance.processor.ComplianceProcessor.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.refinitiv.stream.compliance.processor.ComplianceProcessor.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class AwsConfig {
    private static Map<String,DynamoDBMapper> mappers = new HashMap<>();
    @Bean
    public DynamoDBMapper collabCompanyMapper(){
        String table_name = System.getenv(Constants.COLLAB_COMPANY_DYNAMODB);
        log.info("Table name Loaded ::"+table_name);
        DynamoDBMapper fileMetaMapper = mappers.get(table_name) == null ? getDynamoDBMapper(table_name) : mappers.get(table_name);
        return fileMetaMapper;

    }
    private DynamoDBMapper getDynamoDBMapper(String table_name) {
        DynamoDBMapperConfig mapperConfig = DynamoDBMapperConfig.builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(table_name))
                .build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(getAmazonDynamoDB(),mapperConfig);
        mappers.put(table_name,dynamoDBMapper);
        return dynamoDBMapper;
    }
    private  AmazonDynamoDB getAmazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDBClient = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://0.0.0.0:4566","us-east-1"))
                .build();
        return amazonDynamoDBClient;
    }

    @Bean
    public DynamoDB getDynamoDb(){
        return new DynamoDB(getAmazonDynamoDB());
    }
}
