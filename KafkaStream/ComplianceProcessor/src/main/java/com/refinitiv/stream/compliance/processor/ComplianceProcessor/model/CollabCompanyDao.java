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
public class CollabCompanyDao {
    @DynamoDBHashKey(attributeName = "PK")
    private String pk;
    @DynamoDBRangeKey(attributeName = "SK")
    private String sk;
    @DynamoDBAttribute(attributeName = "EntityType")
    private String entityType;
    @DynamoDBAttribute(attributeName = "Name")
    private String name;
    @DynamoDBAttribute(attributeName = "TAG")
    private String tag;
    @DynamoDBAttribute(attributeName = "IsActive")
    private String isActive;
    @DynamoDBAttribute(attributeName = "Disclaimer")
    private String disclaimer;
    @DynamoDBAttribute(attributeName = "ParentCompanyId")
    private String parentCompanyId;
    @DynamoDBAttribute(attributeName = "ActionCodeIB")
    private String actionCodeIB;
    @DynamoDBAttribute(attributeName = "ActionCodeIP")
    private String actionCodeIP;
    @DynamoDBAttribute(attributeName = "IsEnabledForCompliance")
    private String isEnabledForCompliance;
    @DynamoDBIndexHashKey(attributeName = "GSI1_PK",globalSecondaryIndexName = Constants.GROUP_GSI_NAME)
    private String fromGroup;
    @DynamoDBIndexRangeKey(attributeName = "GSI1_SK",globalSecondaryIndexName = Constants.GROUP_GSI_NAME)
    private String toGroup;
    @DynamoDBAttribute(attributeName = "CreatedDate")
    private String createdDate;
    @DynamoDBAttribute(attributeName = "LastModified")
    private String lastModified;
    @DynamoDBAttribute(attributeName = "IBPolicyMessage")
    private String iBPolicyMessage;
    @DynamoDBAttribute(attributeName = "IPPolicyMessage")
    private String ipPolicyMessage;
    @DynamoDBAttribute(attributeName = "KeyWordMessage")
    private String keyWordMessage;
    @DynamoDBAttribute(attributeName = "Type")
    private String type;
    @DynamoDBAttribute(attributeName = "Email")
    private String email;
    @DynamoDBIndexHashKey(attributeName = "GSI2_PK",globalSecondaryIndexName = Constants.COMPANY_GSI_NAME)
    private String fromCompany;
    @DynamoDBIndexRangeKey(attributeName = "GSI2_SK",globalSecondaryIndexName = Constants.COMPANY_GSI_NAME)
    private String toCompany;
    @DynamoDBAttribute(attributeName = "Source")
    private String source;
}
