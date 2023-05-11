package com.refinitiv.stream.compliance.processor.ComplianceProcessor.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.refinitiv.stream.compliance.processor.ComplianceProcessor.constants.Constants;
import com.refinitiv.stream.compliance.processor.ComplianceProcessor.model.UserGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Slf4j
@Component
public class UserGroupRepository implements IUserGroupRepository{
    @Autowired
    private DynamoDBMapper mapper;

    @Autowired
    private DynamoDB dynamoDB;

    @Override
    public List<UserGroup> fetchGroupRuleByGroupName(UserGroup userGroup) {
        Condition rangeKeyCondition = new Condition();

        rangeKeyCondition
                .withComparisonOperator(ComparisonOperator.BEGINS_WITH)
                .withAttributeValueList(new AttributeValue().withS("GROUP#"));
        DynamoDBQueryExpression<UserGroup> queryExpression = new DynamoDBQueryExpression<>();
        queryExpression.withHashKeyValues(userGroup);
        queryExpression.withRangeKeyCondition(Constants.GSI1_SK,rangeKeyCondition);
        queryExpression.setIndexName(Constants.GROUP_GSI_NAME);
        queryExpression.setConsistentRead(false);   // cannot use consistent read on GSI
        List<UserGroup> results =
                mapper.query(UserGroup.class, queryExpression);

        return results;
    }
}
