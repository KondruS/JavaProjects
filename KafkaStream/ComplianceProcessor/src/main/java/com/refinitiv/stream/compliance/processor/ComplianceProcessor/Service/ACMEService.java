package com.refinitiv.stream.compliance.processor.ComplianceProcessor.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.refinitiv.stream.compliance.processor.ComplianceProcessor.dto.ComplianceDecesion;
import com.refinitiv.stream.compliance.processor.ComplianceProcessor.dto.ComplianceDecesionList;
import com.refinitiv.stream.compliance.processor.ComplianceProcessor.dto.Message;
import com.refinitiv.stream.compliance.processor.ComplianceProcessor.model.UserGroup;
import com.refinitiv.stream.compliance.processor.ComplianceProcessor.repository.IUserGroupRepository;
import com.refinitiv.stream.compliance.processor.ComplianceProcessor.util.GenericUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class ACMEService {

    @Autowired
    public IUserGroupRepository iUserGroupRepository;
    //Group1,Group 4 --> Group 2 ,Group 3

    public String validateMessage(String msgString) {


        //generate random to group
        //generate random from group
        //get data from db
        //evaluate policy
        String compliantResult="";
        Message message= null;
        try {
            message = GenericUtil.ConstructMessageFromJson(msgString);
        } catch (JsonProcessingException e) {
            log.error("Message Formatting Issue while constructing to dto"+e.getMessage());
        }
        List<ComplianceDecesion> activeComplianceDecesionList=message
                .getActiveComplianceDecesionList()
                .getActiveComplianceDecesionList();
        activeComplianceDecesionList.add(new ComplianceDecesion(202,"My Bad"));
        activeComplianceDecesionList.add(new ComplianceDecesion(212,"FO"));

        try {
            compliantResult= GenericUtil.DeconstructMessageToString(message);
        } catch (JsonProcessingException e) {
            log.error("Message Formatting Issue while deconstructing to message as a string"+e.getMessage());
        }

        List<String> fromGroupList= Arrays.asList("GROUP#1", "GROUP#5");
        List<String> toGroupList= Arrays.asList("GROUP#2", "GROUP#3");

     //   List<UserGroup> userGroupList =constructAndFetchGroupPolicies(fromGroupList,toGroupList);

        return compliantResult;
    }

    private List<UserGroup> constructAndFetchGroupPolicies(List<String> fromGroupList, List<String> toGroupList) {
        /* Iterate over from Group
        *   Iterate Over to group
        *       generate UserGroup object with fromgrp & toGrp
        *       call db mapper and pass newly generated UserGroup object
        *        store the List */
        UserGroup userGroup = new UserGroup();
        userGroup.setFromGroup(fromGroupList.get(new Random().nextInt(fromGroupList.size())));
        List<UserGroup> userGroupList = iUserGroupRepository.fetchGroupRuleByGroupName(userGroup);
        userGroupList.stream().forEach(userGroup1-> log.info("UserGroup ::"+userGroup1.toString()));
        log.info("userGroup Setting :: "+userGroupList.toString());
        return userGroupList;
    }
}
