package com.refinitiv.stream.compliance.processor.ComplianceProcessor.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.refinitiv.stream.compliance.processor.ComplianceProcessor.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName = "CollabCompany")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroup {
    @DynamoDBHashKey
    @DynamoDBIndexHashKey(attributeName = "GSI1_PK",globalSecondaryIndexName = Constants.GROUP_GSI_NAME)
    private String fromGroup;
    @DynamoDBRangeKey
    @DynamoDBIndexRangeKey(attributeName = "GSI1_SK",globalSecondaryIndexName = Constants.GROUP_GSI_NAME)
    private String toGroup;
    @DynamoDBAttribute(attributeName = "PK")
    private String companyID;
    @DynamoDBAttribute(attributeName = "SK")
    private String ruleId;
    @DynamoDBAttribute(attributeName = "EntityType")
    private String entityType;
    @DynamoDBAttribute(attributeName = "ActionCodeIB")
   private String actionCodeIB;
    @DynamoDBAttribute(attributeName = "ActionCodeIP")
    private String actionCodeIP;
    @DynamoDBAttribute(attributeName = "Source")
    private String source;
}
