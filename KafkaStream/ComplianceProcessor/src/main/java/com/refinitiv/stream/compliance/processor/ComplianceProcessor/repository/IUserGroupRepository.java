package com.refinitiv.stream.compliance.processor.ComplianceProcessor.repository;

import com.refinitiv.stream.compliance.processor.ComplianceProcessor.model.UserGroup;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserGroupRepository {
    List<UserGroup> fetchGroupRuleByGroupName(UserGroup userGroup);
}
