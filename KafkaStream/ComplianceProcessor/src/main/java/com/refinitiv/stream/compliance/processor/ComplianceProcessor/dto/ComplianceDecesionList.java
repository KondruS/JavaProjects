package com.refinitiv.stream.compliance.processor.ComplianceProcessor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplianceDecesionList {
    private List<ComplianceDecesion> activeComplianceDecesionList;
    public List<ComplianceDecesion> getActiveComplianceDecesionList(){
        if(activeComplianceDecesionList == null){
            this.activeComplianceDecesionList =new ArrayList<ComplianceDecesion>();
        }
        return activeComplianceDecesionList;
    }
}
