package com.refinitiv.stream.compliance.processor.ComplianceProcessor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String chatRoomId;
    private String messageId;
    private String createAt;
    private String messageType;
    private String message;
    private String attachmentReference;
    private String userId;
    private ComplianceDecesionList activeComplianceDecesionList;
    public ComplianceDecesionList getActiveComplianceDecesionList(){
        if( this.activeComplianceDecesionList == null){
            this.activeComplianceDecesionList= new ComplianceDecesionList();
        }
        return  activeComplianceDecesionList;
    }

}
