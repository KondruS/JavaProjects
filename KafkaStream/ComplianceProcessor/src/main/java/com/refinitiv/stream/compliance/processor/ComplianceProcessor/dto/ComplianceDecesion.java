package com.refinitiv.stream.compliance.processor.ComplianceProcessor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComplianceDecesion {
    private Integer reasonId;
    private String reasonMsg;
}
